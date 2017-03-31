package com.redshiftsoft.example.scala.functions

import org.junit.{Assert, Test}

/**
  * Tests of the functions in/on scala.Function
  */
class Functions_Methods_UT {

  @Test def andThen(): Unit = {
    val doubler = (i: Int) => i * 2
    val plus3 = (i: Int) => i + 3
    Assert.assertEquals(203, (doubler andThen plus3) (100))
  }

  @Test def compose(): Unit = {
    val doubler = (i: Int) => i * 2
    val plus3 = (i: Int) => i + 3
    Assert.assertEquals(206, (doubler compose plus3) (100))
  }

  @Test def tupled(): Unit = {
    val multiply = (d1: Long, d2: Long) => d1 * d2
    val multiplyTuple = Function.tupled(multiply)

    Assert.assertEquals(12, multiply(3, 4))
    Assert.assertEquals(30, multiplyTuple((5, 6)))
  }

}