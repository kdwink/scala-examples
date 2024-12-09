package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.{assertEquals, assertTrue}
import org.junit.jupiter.api.Test


class Expressions_UT {

  @Test def block(): Unit = {
    val x = {
      val y = 100
      val z = 10
      y + 1 + z
    }
    assertEquals(111, x)
  }

  @Test def blockNested(): Unit = {
    val x = {
      val y = 100
      val z = {
        5
      }
      y + 1 + z
    }
    assertEquals(106, x)
  }

  @Test def ifElse(): Unit = {
    val x = 10
    val y = 100
    val z = if (x > y) -10 else 10
    assertEquals(10, z)

    var flag = false
    if (x > 1) {
      flag = true
    }
    assertTrue(flag)
  }

  @Test def ifExpression(): Unit = {
    val string1: String = null
    val string2: String = "hello"

    val r1 = if (string1 == null) "x" else string1
    val r2 = if (string2 == null) "y" else string2

    assertTrue(r1.isInstanceOf[String])
    assertTrue(r2.isInstanceOf[String])

    assertEquals("x", r1)
    assertEquals("hello", r2)
  }

}