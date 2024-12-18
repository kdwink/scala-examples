package com.redshiftsoft.example.scala.functions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Functions_Invoking_UT:

  @Test def invokeWithOperatorNotation(): Unit =
    // In earlier versions of scala the period proceeding the substring function could be omitted.
    assertEquals("eith", "Keith".substring(1))
    assertEquals("ei", "Keith".substring(1, 3))

  @annotation.nowarn
  @Test def withAndWithoutParenthesis(): Unit =
    def accessDBFunc(): Int = 20

    // assertEquals(20, accessDBFunc) <--- cannot do in scala 3
    assertEquals(20, accessDBFunc())

  @Test def withApply(): Unit =

    val doubler1: Int => Int = (i: Int) => i * 2

    def doubler2(i: Int): Int = i * 2

    def invokeIt[T](f: Int => T): T = f(8)

    assertEquals(14, doubler1(7))
    assertEquals(14, doubler2(7))

    assertEquals(16, invokeIt(doubler1))
    assertEquals(16, invokeIt(doubler2))

    assertEquals(14, doubler1.apply(7))
    //assertEquals(14, doubler2.apply(7))


