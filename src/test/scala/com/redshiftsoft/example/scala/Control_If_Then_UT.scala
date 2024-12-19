package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.{assertEquals, assertTrue}
import org.junit.jupiter.api.Test

class Control_If_Then_UT:

  @Test def if_then_else_single_line_1(): Unit =
    val x = 10
    val y = 100
    val z = if x > y then -10 else 10
    assertEquals(10, z)

  @Test def if_then_else_single_line_2(): Unit =
    val string1: String = null
    val string2: String = "hello"

    val r1 = if string1 == null then "x" else string1
    val r2 = if string2 == null then "y" else string2

    assertTrue(r1.isInstanceOf[String])
    assertTrue(r2.isInstanceOf[String])

    assertEquals("x", r1)
    assertEquals("hello", r2)

  @Test def if_then_else_multiline(): Unit =
    val x = 10

    var flag1 = false
    var flag2 = false
    if x > 1 then
      flag1 = true
      flag2 = true

      assertTrue(flag1)
      assertTrue(flag2)

