package com.redshiftsoft.example.scala.collections.monadic


import org.junit.{Assert, Test}

import scala.concurrent.ExecutionContext.Implicits.{Future, global}
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
      Thread.sleep(100)
      123
    }

    val s = Future sequence Seq(
      Future(slowFunction("s1")),
      Future(slowFunction("s1")),
      Future(slowFunction("s1")),
      Future(slowFunction("s1")),
      Future(slowFunction("s2"))
    )

  }


}
