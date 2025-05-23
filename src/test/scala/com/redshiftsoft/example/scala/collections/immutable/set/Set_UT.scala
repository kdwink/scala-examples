package com.redshiftsoft.example.scala.collections.immutable.set

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

class Set_UT:

  @Test def declaring(): Unit =
    val unique = Set(2, 3, 2, 3, 2, 2, 2, 3, 2, 3, 3, 3, 3, 2, 3)
    assertEquals(2, unique.size)

  @Test def accessing(): Unit =
    val colors = Set("red", "blue", "green")
    assertEquals("red", colors.head)
    assertEquals(Set("blue", "green"), colors.tail)

  @Test def iterating(): Unit =
    val numbers = Set(1, 2, 3, 4, 5, 6, 7, 8, 9)
    var sum = 0
    for x <- numbers do sum += x
    assertEquals(45, sum)

  @Test def mapAndReduce(): Unit =
    val numbers = Set(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = numbers.map(s => s * 2).reduce((a, b) => 2 * a + 2 * b)
    assertEquals(7880, result)

  @Test def diff(): Unit =
    val numbers = Set(1, 2, 3, 4, 5, 6, 7, 8, 9)
    // when
    val result1 = numbers.diff(Set(6, 7, 9))
    val result2 = numbers -- Set(6, 7, 9)
    // then
    assertEquals(Set(1, 2, 3, 4, 5, 8), result1)
    assertEquals(Set(1, 2, 3, 4, 5, 8), result2)
    assertEquals(Set(1, 2, 3, 4, 5, 6, 7, 8, 9), numbers)

