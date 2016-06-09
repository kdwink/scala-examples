package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Operators_UT {

  @Test
  def mod(): Unit = {
    val x = 20 % 7
    Assert.assertEquals(6, x)
  }

}
