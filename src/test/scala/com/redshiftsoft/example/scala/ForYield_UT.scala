package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

import scala.collection.immutable.Seq

class ForYield_UT {

  @Test def for_yield(): Unit = {
    val twos = for (x <- 1 to 7) yield {
      2 * x
    }
    Assert.assertEquals("Vector(2, 4, 6, 8, 10, 12, 14)", twos.toString)
  }

  @Test def for_yield_alternate_syntax(): Unit = {
    val twos = for {x <- 1 to 7} yield 2 * x
    Assert.assertEquals("Vector(2, 4, 6, 8, 10, 12, 14)", twos.toString)
  }

  @Test def for_yield_with_guard(): Unit = {
    val threes = for (x <- 1 to 20 if x % 3 == 0) yield {
      x
    }
    Assert.assertEquals("Vector(3, 6, 9, 12, 15, 18)", threes.toString)
  }

  @Test def for_yield_two_variables(): Unit = {
    val result: Seq[String] = for {x <- 1 to 3
                                   y <- 4 to 5} yield {
      s"$x-$y"
    }
    Assert.assertEquals("Vector(1-4, 1-5, 2-4, 2-5, 3-4, 3-5)", result.toString)
  }

  @Test def for_yield_two_variables_second_dependent_on_first(): Unit = {
    val result: Seq[String] = for {x <- 1 to 6
                                   y = 2 * x} yield {
      s"$x-$y"
    }
    Assert.assertEquals("Vector(1-2, 2-4, 3-6, 4-8, 5-10, 6-12)", result.toString)
  }


}