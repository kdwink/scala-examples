package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Expressions_UT {

  @Test def expression(): Unit = {
    val x = {
      val y = 100
      val z = 10
      y + 1 + z
    }
    Assert.assertEquals(111, x)
  }

}
