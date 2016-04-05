package com.redshiftsoft.example.scala.collections.monadic


import org.junit.{Assert, Test}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future, Promise}

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

    val race: Future[Long] = successRace(
      Future(sleepFunction(120)),
      Future(sleepFunction(60))
    )

    Assert.assertEquals(60, Await.result(race, Duration(250, MILLISECONDS)))
  }

  def successRace[T](f1: Future[T], f2: Future[T]): Future[T] = {
    val promise = Promise[T]()

    f1.onComplete(x => {
      promise.tryComplete(x)
    })
    f2.onComplete(x => {
      promise.tryComplete(x)
    })

    promise.future
  }


}
