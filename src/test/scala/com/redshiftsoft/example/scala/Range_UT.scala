package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

import scala.math.BigDecimal

class Range_UT {

  @Test
  def literals(): Unit = {
    val range = 1 to 10
    val range2 = BigDecimal("1.0") to 15.5d by .5
  }

  @Test
  def foreach(): Unit = {
    var count = 0

    1 to 10 foreach (i => {
      count = count + 1
    })

    assertEquals(10, count)

  }

  @Test
  def map(): Unit = {
    val seq1 = (1 to 5).map(x => 2 * x)
    assertEquals(5, seq1.size)

    val seq2 = (1 to 1).map(x => 2 * x)
    assertEquals(1, seq2.size)

    val seq3 = (1 to 0).map(x => 2 * x)
    assertEquals(0, seq3.size)
  }

}
