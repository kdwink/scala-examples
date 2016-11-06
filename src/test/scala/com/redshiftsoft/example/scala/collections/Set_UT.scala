package com.redshiftsoft.example.scala.collections

import org.junit.{Assert, Test}

class Set_UT {

  @Test def declaring(): Unit = {
    val unique = Set(2, 3, 2, 3, 2, 2, 2, 3, 2, 3, 3, 3, 3, 2, 3)
    Assert.assertEquals(2, unique.size)
  }

  @Test def accessing(): Unit = {
    val colors = Set("red", "blue", "green")
    Assert.assertEquals("red", colors.head)
    Assert.assertEquals(Set("blue", "green"), colors.tail)
  }

  @Test def iterating(): Unit = {
    val numbers = Set(1, 2, 3, 4, 5, 6, 7, 8, 9)
    var sum = 0
    for (x <- numbers) sum += x
    Assert.assertEquals(45, sum)
  }

  @Test def mapAndReduce(): Unit = {
    val numbers = Set(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = numbers.map(s => s * 2).reduce((a, b) => 2 * a + 2 * b)
    Assert.assertEquals(7880, result)
  }

}