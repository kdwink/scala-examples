package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.{assertEquals, assertTrue}
import org.junit.jupiter.api.Test


class Expressions_UT:

  @Test def block(): Unit =
    val x =
      val y = 100
      val z = 10
      y + 1 + z
    assertEquals(111, x)

  @Test def blockNested(): Unit =
    val x =
      val y = 100
      val z =
        5
      y + 1 + z
    assertEquals(106, x)

