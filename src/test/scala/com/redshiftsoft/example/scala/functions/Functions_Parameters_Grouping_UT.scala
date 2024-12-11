package com.redshiftsoft.example.scala.functions

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test


/**
 *  Methods may define multiple parameter lists.
 *
 *  Applications:
 *  - Drive type inference: The compiler can infer types with fewer hints.
 *  - Implicit parameters: An entire group can be implicit.
 *  - Partial application:  When a method is called with a fewer number of parameter lists, then this will yield a
 *  function taking the missing parameter lists as its arguments. This is formally known as partial application.
 *
 */
class Functions_Parameters_Grouping_UT {

  @Test def parameterGrouping(): Unit = {

    def f(x: Int)(y: Int, z: Int) = x + y * z

    assertEquals(7, f(1)(2, 3))
    assertEquals(7, f(1)(2, 3))
  }

  @Test def parameterGrouping_WithFunctionParam_1(): Unit = {
    def f(x: Int)(y: Int => Int) = y(x) * 3

    assertEquals(12, f(3) { s => s + 1 })
    assertEquals(12, f(3)({ s => s + 1 }))
  }

  @Test def parameterGrouping_WithFunctionParam_2(): Unit = {
    def f(x: Int)(y: () => Int) = y() * x

    assertEquals(30, f(3)(() => {
      5 + 5
    }))
  }

  @Test def parameterGrouping_WithFunctionParam_3(): Unit = {
    def f(x: Int)(y: => Int) = y * x

    assertEquals(24, f(2)(6 + 6))
    assertEquals(24, f(2)({
      6 + 6
    }))
    assertEquals(24, f(2) {
      6 + 6
    })
  }


  @Test def parameterGrouping_WithFunctionParam_4(): Unit = {
    def f(x: Int)(y: Int => Int, z: Int => Int) = y(x) * z(x)

    assertEquals(9, f(2)({ s => s + 1 }, { s => s + 1 }))
  }

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // Currying: parameter grouping can be used for a slightly more concise function currying
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @Test def curryingWithNoGrouping(): Unit = {
    def factorOf(x: Int, y: Int) = y % x == 0

    def isEven(x: Int) = factorOf(2, x)

    assertTrue(isEven(32))
    assertFalse(isEven(31))
  }

  @Test def curryingWithParameterGrouping(): Unit = {
    def factorOf(x: Int)(y: Int) = y % x == 0

    val isEven1 = factorOf(2)
    val isEven2 = factorOf(2)(_)

    assertTrue(isEven1(32))
    assertFalse(isEven1(31))

    assertTrue(isEven2(32))
    assertFalse(isEven2(31))
  }

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  //
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @Test def practicalExample(): Unit = {
    val numbers = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numberFunc = numbers.foldLeft(Seq[Int]())

    val squares = numberFunc((xs, x) => xs :+ x * x)
    assertEquals(Seq(1, 4, 9, 16, 25, 36, 49, 64, 81, 100), squares)

    val cubes = numberFunc((xs, x) => xs :+ x * x * x)
    assertEquals(Seq(1, 8, 27, 64, 125, 216, 343, 512, 729, 1000), cubes)
  }


}
