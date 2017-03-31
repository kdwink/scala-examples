package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Operators_UT {

  @Test def operatorsAreMethods(): Unit = {
    val answer1 = 100 + 42
    val answer2 = 100.+(42)

    Assert.assertEquals(142, answer1)
    Assert.assertEquals(142, answer2)
  }

  @Test
  def mod(): Unit = {
    val x = 20 % 7
    Assert.assertEquals(6, x)
  }

}
