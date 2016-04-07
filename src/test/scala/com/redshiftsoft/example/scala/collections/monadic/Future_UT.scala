package com.redshiftsoft.example.scala.collections.monadic


import org.junit.{Assert, Test}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future, Promise}
import scala.util.{Random, Try}

class Future_UT {

  @Test def simple(): Unit = {
    val someFuture = Future {
      123
    }
    val maxTime = Duration(10, SECONDS)
    Assert.assertEquals(123, Await.result(someFuture, maxTime))
  }

  @Test def complex(): Unit = {
    /* These run in 50 ms each so running 20 of them serially would take 1s */
    def slowFunction(name: String): Int = {
      Thread.sleep(50)
      123
    }

    val s = Future sequence Seq(
      Future(slowFunction("s1")),
      Future(slowFunction("s1")),
      Future(slowFunction("s1")),
      Future(slowFunction("s1")),
      Future(slowFunction("s2"))
    )

    val result = Await.result(s, Duration(10, SECONDS))
    Assert.assertEquals(List(123, 123, 123, 123, 123), result.toList)
  }

  @Test def firstCompleted(): Unit = {
    /* These run in 50 ms each so running 20 of them serially would take 1s */
    def sleepFunction(ms: Long): Long = {
      Thread.sleep(ms)
      ms
    }

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