package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Loops_UT {

  @Test
  def forYields() = {
    var result = for {x <- 1 to 3
                      y <- 4 to 5} yield {
      s"$x-$y"
    }
    Assert.assertEquals("Vector(1-4, 1-5, 2-4, 2-5, 3-4, 3-5)", result.toString)
  }

  @Test
  def forNested() = {
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
