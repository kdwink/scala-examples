package com.redshiftsoft.example.scala.collections.monadic


import org.junit.{Assert, Test}

import scala.concurrent.Await
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

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


}
