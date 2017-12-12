package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

import scala.collection.immutable.Seq

class Loops_UT {

  @Test def forYields(): Unit = {
    val result: Seq[String] = for {x <- 1 to 3
                                   y <- 4 to 5} yield {
      s"$x-$y"
    }
    Assert.assertEquals("Vector(1-4, 1-5, 2-4, 2-5, 3-4, 3-5)", result.toString)
  }

  @Test def forNested(): Unit = {
    val twos = for (x <- 1 to 7) yield {
      2 * x
    }
    val threes = for (x <- 1 to 20 if x % 3 == 0) yield {
      x
    }
    Assert.assertEquals("Vector(2, 4, 6, 8, 10, 12, 14)", twos.toString)
    Assert.assertEquals("Vector(3, 6, 9, 12, 15, 18)", threes.toString)
  }

  @Test def forOneToOne(): Unit = {
    var loop = false
    for(_ <- 1 to 1) {
      loop = true
    }
    Assert.assertTrue(loop)
  }

}