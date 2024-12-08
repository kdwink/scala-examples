package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

import scala.annotation.targetName


class Operators_UT {

  @Test def operatorsAreMethods(): Unit = {
    val answer1 = 100 + 42
    val answer2 = 100.+(42)

    assertEquals(142, answer1)
    assertEquals(142, answer2)
  }

  @Test def mod(): Unit = {
    val x = 20 % 7
    assertEquals(6, x)
  }

  @Test def overloading(): Unit = {

    class Ball(initialSum: Int) {
      @targetName("add")
      def +(ball: Ball): Unit = {
        this.sum = this.sum + ball.sum
      }

      var sum: Int = initialSum
    }

    val b1 = new Ball(10)
    val b2 = new Ball(20)

    b1 + b2

    assertEquals(30, b1.sum)

  }

  @Test def plusEqual(): Unit = {
    var x = 1
    x += 2

    assertEquals(3, x)
  }

  @Test def bitWiseExclusiveOr(): Unit =
    assertEquals(1, 1 ^ 0)
    assertEquals(1, 0 ^ 1)
    assertEquals(0, 1 ^ 1)
    assertEquals(0, 0 ^ 0)

    // happens to work with boolean values
    assertEquals(false, true ^ true)
    assertEquals(false, false ^ false)

    assertEquals(true, true ^ false)
    assertEquals(true, false ^ true)
}
