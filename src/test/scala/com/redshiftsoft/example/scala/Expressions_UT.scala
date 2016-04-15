package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Expressions_UT {

  @Test def block(): Unit = {
    val x = {
      val y = 100
      val z = 10
      y + 1 + z
    }
    Assert.assertEquals(111, x)
  }

  @Test def blockNested(): Unit = {
    val x = {
      val y = 100
      val z = {
        5
      }
      y + 1 + z
    }
    Assert.assertEquals(106, x)
  }

  @Test def ifElse(): Unit = {
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

  @Test def ifExpression() {
    val string1: String = null
    val string2: String = "hello"

    val r1 = if (string1 == null) "x" else string1
    val r2 = if (string2 == null) "y" else string2

    Assert.assertTrue(r1.isInstanceOf[String])
    Assert.assertTrue(r2.isInstanceOf[String])

    Assert.assertEquals("x", r1)
    Assert.assertEquals("hello", r2)
  }

}