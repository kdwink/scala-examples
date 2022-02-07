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

  @Test def guard(): Unit = {
    val result = ListBuffer.empty[Int]
    for (x <- 1 to 10 if x % 3 == 0)
      result.append(x)
    Assert.assertEquals(Seq(3, 6, 9), result.toSeq)
  }


  @Test def forOneToOne(): Unit = {
    var count = 0
    for (x <- 1 to 1) {
      count = count + x
    }
    Assert.assertEquals(1, count)
  }

  @Test def sequence(): Unit = {
    val seq = Seq("a", "bb", "ccc", "dddd", "eeeee")
    val buffer = ListBuffer.empty[String]
    for (x <- seq.reverse) {
      buffer.append(x)
    }
    Assert.assertEquals(Seq("eeeee", "dddd", "ccc", "bb", "a"), buffer.toSeq)
  }

  @Test def sequenceIndex(): Unit = {
    val seq = Seq("a", "bb", "ccc", "dddd", "eeeee")
    val buffer = ListBuffer.empty[String]
    for (i <- seq.indices) {
      buffer.append(seq(i))
    }
    Assert.assertEquals(Seq("a", "bb", "ccc", "dddd", "eeeee"), buffer.toSeq)
  }


}
