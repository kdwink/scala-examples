package com.redshiftsoft.example.scala.collections

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IterableOnce_UT:

  @Test def sum(): Unit =
    val numbers = List(1, 2, 3, 4, 5)
    val result = numbers.sum
    assertEquals(15, result)

@Test def reduce(): Unit =
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val result = numbers.reduce((a, b) => 1 + a + b)
  assertEquals(53, result)

@Test def reduce_withPlaceholders(): Unit =
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val result = numbers.reduce(1 + _ + _)
  assertEquals(53, result)