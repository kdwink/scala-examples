package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

import scala.collection.immutable.Seq

/**
 * For Comprehensions
 *
 * https://docs.scala-lang.org/tour/for-comprehensions.html
 */
class For_Comprehensions_UT:

  @Test def for_yield(): Unit =
    val twos = for x <- 1 to 7 yield
      2 * x
    assertEquals("Vector(2, 4, 6, 8, 10, 12, 14)", twos.toString)

  @Test def for_yield_alternate_syntax(): Unit =
    val twos = for x <- 1 to 7 yield 2 * x
    assertEquals("Vector(2, 4, 6, 8, 10, 12, 14)", twos.toString)

  @Test def for_yield_with_guard(): Unit =
    val threes = for x <- 1 to 20 if x % 3 == 0 yield x
    assertEquals("Vector(3, 6, 9, 12, 15, 18)", threes.toString)

  @Test def for_yield_two_variables(): Unit =
    // when
    val result1: Seq[String] = for x <- 1 to 3; y <- 4 to 5 yield s"$x-$y"
    val result2: Seq[String] = for (x <- 1 to 3; y <- 4 to 5) yield s"$x-$y"
    val result3: Seq[String] = for {x <- 1 to 3; y <- 4 to 5} yield s"$x-$y"

    // then
    assertEquals("Vector(1-4, 1-5, 2-4, 2-5, 3-4, 3-5)", result1.toString)
    assertEquals("Vector(1-4, 1-5, 2-4, 2-5, 3-4, 3-5)", result2.toString)
    assertEquals("Vector(1-4, 1-5, 2-4, 2-5, 3-4, 3-5)", result3.toString)

  @Test def for_yield_two_variables_two_guards(): Unit =
    val result: Seq[String] = for x <- 1 to 3 if x == 1
                                   y <- 4 to 5 if y == 5 yield
      s"$x-$y"
    assertEquals("Vector(1-5)", result.toString)


  @Test def for_yield_two_variables_second_dependent_on_first(): Unit =
    val result: Seq[String] = for x <- 1 to 6
                                   y = 2 * x yield
      s"$x-$y"
    assertEquals("Vector(1-2, 2-4, 3-6, 4-8, 5-10, 6-12)", result.toString)

  @Test def for_yield_option(): Unit =
    val option = Some(25)
    val result: Option[Int] = for x <- option yield x * 3
    assertEquals("Some(75)", result.toString)

  @Test def for_yield_option_2(): Unit =
    val option1 = Some(5)
    val option2 = Some(19)
    val result: Option[(Int, Int)] = for x <- option1
                                          y <- option2 yield (x * 3, y * 2)
    assertEquals("Some((15,38))", result.toString)