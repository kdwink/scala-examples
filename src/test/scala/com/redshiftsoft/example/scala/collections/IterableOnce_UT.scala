package com.redshiftsoft.example.scala.collections

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IterableOnce_UT:

  @Test def sum(): Unit =
    val numbers = List(1, 2, 3, 4, 5)
    val result = numbers.sum
    assertEquals(15, result)