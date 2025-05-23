package com.redshiftsoft.example.scala

import org.junit.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Expressions_Variables_UT:

  @Test
  def declaring(): Unit = 

    val x1 = 20
    val y1 = "abcd"
    val z1 = 'c'

    val x2: Int = 20
    val y2: String = "abcd"
    val z2: Char = 'c'

    assertEquals(x1, x2)
    assertEquals(y1, y2)
    assertEquals(z1, z2)

  @Test
  def tupleUnpacking(): Unit = 
    // when
    val (x, y, z) = (1, 2, 3)

    // then
    assertEquals(x, 1)
    assertEquals(y, 2)
    assertEquals(z, 3)
