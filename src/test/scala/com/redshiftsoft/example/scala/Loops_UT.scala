package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Loops_UT {

  @Test
  def forTest() = {

    val twos = for (x <- 1 to 7) yield {
      2 * x
    }

    val threes = for (x <- 1 to 20 if x % 3 == 0) yield {
      x
    }

    Assert.assertEquals("Vector(2, 4, 6, 8, 10, 12, 14)", twos.toString)
    Assert.assertEquals("Vector(3, 6, 9, 12, 15, 18)", threes.toString)

  }

}
