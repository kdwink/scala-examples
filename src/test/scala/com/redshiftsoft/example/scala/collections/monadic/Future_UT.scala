package com.redshiftsoft.example.scala.collections.monadic


import java.util.concurrent.Executors

import org.junit.{Assert, Test}

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future, Promise}
import scala.util.{Random, Try}

class Future_UT {

  val ThreadPoolSize = 16

  /* The default seems to be # of cores, or close to.  Some of the tests in this class assume 10+ executors
     will run concurrently so the following is necessary for them to pass on a low core machine.*/
  implicit val ec = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(ThreadPoolSize))

  @Test def simple(): Unit = {
    val someFuture = Future {
      123
    }
    val maxTime = Duration(10, SECONDS)
    Assert.assertEquals(123, Await.result(someFuture, maxTime))
  }

  @Test def waitingForCollectionOfFutures(): Unit = {
    /* These run in 50 ms each so running 20 of them serially would take 1s */
    def slowFunction(name: String): String = {
      Thread.sleep(50)
      name
    }

    val startTime = System.currentTimeMillis()
    var futureSeq: Seq[Future[String]] = Seq()
    for (i <- 1 to ThreadPoolSize) {
      futureSeq = futureSeq :+ Future(slowFunction("s" + i))
    }

    val topFuture = Future.sequence(futureSeq)

    /* These all run in parallel so they should take approx 50 ms */
    val result = Await.result(topFuture, Duration(400, MILLISECONDS))
    Assert.assertEquals(List("s1", "s2", "s3", "s4", "s5", "s6", "s7", "s8", "s9", "s10", "s11", "s12", "s13", "s14", "s15", "s16"), result.toList)
  }

  /**
    * Calling map on a function lets you map the result of the future and returns another future.
    */
  @Test def map(): Unit = {
    val lngFuture: Future[Long] = Future(sleepFunction(100))
    val strFuture: Future[String] = lngFuture.map(intResult => "" + intResult)
    val tupleFuture: Future[(String, String)] = strFuture.map(str => ("1-" + str, "2-" + str))

    while (!tupleFuture.isCompleted) {
    }
    Assert.assertEquals("Success((1-100,2-100))", tupleFuture.value.get.toString)
  }


  @Test def firstCompleted(): Unit = {


    var list = List(
      Future(sleepFunction(24000)), // really slow
      Future(sleepFunction(240)),
      Future(sleepFunction(180)),
      Future(sleepFunction(-1)), // throws exception
      Future(sleepFunction(480)),
      Future(sleepFunction(3)),
      Future(sleepFunction(200)),
      Future(sleepFunction(12000)) // pretty slow
    )
    list = Random.shuffle(list)

    val race: Future[Long] = successRace(list)

    // This will throw if it takes longer than 250ms, so we know we are returning sooner.
    val result: Long = Await.result(race, Duration(250, MILLISECONDS))
    Assert.assertEquals(3, result)
  }

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  //
  //
  //
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  /* These run in 50 ms each so running 20 of them serially would take 1s */
  def sleepFunction(ms: Long): Long = {
    Thread.sleep(ms)
    ms
  }

  /**
    * Takes a list of futures and returns the result from the first Successful one.
    */
  def successRace[T](futureList: List[Future[T]]): Future[T] = {
    val promise = Promise[T]()

    def individualCompletionHandler(theTry: Try[T]): Unit = {
      if (theTry.isSuccess)
        promise.tryComplete(theTry)
    }
    futureList.foreach(f => f.onComplete(individualCompletionHandler))

    promise.future
  }

}