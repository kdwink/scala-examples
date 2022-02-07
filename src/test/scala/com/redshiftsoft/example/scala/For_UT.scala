package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

import scala.collection.mutable.ListBuffer

class For_UT {

  @Test def simple(): Unit = {
    var count = 0
    for (x <- 1 to 10) {
      count = count + x
    }
    Assert.assertEquals(55, count)
  }

  @Test def forOneToOne(): Unit = {
    var count = 0
    for (x <- 1 to 1) {
      count = count + x
    }
    Assert.assertEquals(1, count)
  }

  @Test def sequence(): Unit = {
    var seq = Seq("a", "bb", "ccc", "dddd", "eeeee")
    val buffer = ListBuffer.empty[String]
    for (x <- seq.reverse) {
      buffer.append(x)
    }
    Assert.assertEquals(Seq("eeeee", "dddd", "ccc", "bb", "a"), buffer.toSeq)
  }


}
