package com.redshiftsoft.example.scala.functions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Functions_Reference_UT {

  //noinspection ScalaUnnecessaryParentheses
  @Test def functionReference(): Unit =
    def doString() = "whatever"

    def doDouble(x: Int): Int = 2 * x

    def doSum(x: Int, y: Int): Int = x + y


    val literalPointer: () => String = doString
    val doublePointer1: Int => Int = doDouble
    val doublePointer2: (Int) => Int = doDouble
    val doublePointer3 = doDouble

    val sumPointer1: (Int, Int) => Int = doSum
    val sumPointer2 = doSum

    assertEquals("whatever", literalPointer())

    assertEquals(10, doublePointer1(5))
    assertEquals(10, doublePointer2(5))
    assertEquals(10, doublePointer3(5))

    assertEquals(11, sumPointer1(5, 6))
    assertEquals(11, sumPointer2(5, 6))

  @Test def refToAnonymousFunctionLiteral(): Unit =
    val doubler1 = (x: Int) => x * 2
    assertEquals(100, doubler1(50))

  @Test def placeholder(): Unit =
    val doubler: Int => Int = _ * 2
    assertEquals(100, doubler(50))

    val subtractFunc: (Int, Int) => Int = _ - _
    assertEquals(49, subtractFunc(50, 1))
    assertEquals(-49, subtractFunc(1, 50))


}