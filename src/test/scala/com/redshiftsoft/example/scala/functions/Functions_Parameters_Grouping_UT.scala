package com.redshiftsoft.example.scala.functions

import org.junit.{Assert, Test}

/**
 * Methods may define multiple parameter lists. When a method is called with a fewer number of parameter lists, then
 * this will yield a function taking the missing parameter lists as its arguments. This is formally known as currying.
 */
class Functions_Parameters_Grouping_UT {


  @Test def parameterGrouping(): Unit = {

    def f(x: Int)(y: Int, z: Int) = x + y * z

    Assert.assertEquals(7, f(1)(2, 3))
    Assert.assertEquals(7, f(1)(2, 3))
  }

  @Test def parameterGrouping_WithFunctionParam_1(): Unit = {
    def f(x: Int)(y: Int => Int) = y(x) * 3

    Assert.assertEquals(12, f(3) { s => s + 1 })
    Assert.assertEquals(12, f(3)({ s => s + 1 }))
  }

  @Test def parameterGrouping_WithFunctionParam_2(): Unit = {
    def f(x: Int)(y: () => Int) = y() * x

    Assert.assertEquals(30, f(3)(() => {
      5 + 5
    }))
  }

  @Test def parameterGrouping_WithFunctionParam_3(): Unit = {
    def f(x: Int)(y: => Int) = y * x

    Assert.assertEquals(24, f(2)(6 + 6))
    Assert.assertEquals(24, f(2)({
      6 + 6
    }))
    Assert.assertEquals(24, f(2) {
      6 + 6
    })
  }


  @Test def parameterGrouping_WithFunctionParam_4(): Unit = {
    def f(x: Int)(y: Int => Int, z: Int => Int) = y(x) * z(x)

    Assert.assertEquals(9, f(2)({ s => s + 1 }, { s => s + 1 }))
  }

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // Currying: parameter grouping can be used for a slightly more concise function currying
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @Test def curryingWithNoGrouping(): Unit = {
    def factorOf(x: Int, y: Int) = y % x == 0

    def isEven(x: Int) = factorOf(2, x)

    Assert.assertTrue(isEven(32))
    Assert.assertFalse(isEven(31))
  }

  @Test def curryingWithParameterGrouping(): Unit = {
    def factorOf(x: Int)(y: Int) = y % x == 0

    val isEven1 = factorOf(2) _
    val isEven2 = factorOf(2)(_)

    Assert.assertTrue(isEven1(32))
    Assert.assertFalse(isEven1(31))

    Assert.assertTrue(isEven2(32))
    Assert.assertFalse(isEven2(31))
  }

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  //
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @Test def practicalExample(): Unit = {
    val numbers = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val numberFunc = numbers.foldLeft(Seq[Int]()) _

    val squares = numberFunc((xs, x) => xs :+ x * x)
    Assert.assertEquals(Seq(1, 4, 9, 16, 25, 36, 49, 64, 81, 100), squares)

    val cubes = numberFunc((xs, x) => xs :+ x * x * x)
    Assert.assertEquals(Seq(1, 8, 27, 64, 125, 216, 343, 512, 729, 1000), cubes)
  }


}
