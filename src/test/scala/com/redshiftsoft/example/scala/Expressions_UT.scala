package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Expressions_UT {

  @Test def expressionBlock(): Unit = {
    val x = {
      val y = 100
      val z = 10
      y + 1 + z
    }
    Assert.assertEquals(111, x)
  }

  @Test def expressionBlockNested(): Unit = {
    val x = {
      val y = 100
      val z = {
        5
      }
      y + 1 + z
    }
    Assert.assertEquals(106, x)
  }

  @Test
  def expressionIfElse(): Unit = {
    val x = 10
    val y = 100
    val z = if (x > y) -10 else 10
    Assert.assertEquals(10, z)

    var flag = false
    if (x > 1) {
      flag = true
    }
    Assert.assertTrue(flag)
  }


}
