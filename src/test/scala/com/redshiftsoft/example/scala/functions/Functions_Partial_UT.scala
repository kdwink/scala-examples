package com.redshiftsoft.example.scala.functions

import org.junit.{Assert, Test}

class Functions_Partial_UT {

  private val statusHandler1: PartialFunction[Int, String] = {
    case 100 => "Huh"
  }

  private val statusHandler2: PartialFunction[Int, String] = {
    case 200 => "Okay"
    case 400 => "Error"
    case 500 => "Our Error"
  }

  @Test def invokeDirectly(): Unit = {
    Assert.assertEquals("Okay", statusHandler2(200))
    Assert.assertEquals("Error", statusHandler2(400))
    Assert.assertEquals("Our Error", statusHandler2(500))
  }

  @Test def partialMatchError(): Unit = {
    var flag: Boolean = false
    try {
      Assert.assertEquals("Our Error", statusHandler2(550))
    } catch {
      case e: MatchError =>
        flag = true
    }
    Assert.assertTrue(flag)
  }

  //noinspection AccessorLikeMethodIsUnit
  @Test def isDefinedAt(): Unit = {
    Assert.assertTrue(statusHandler1.isDefinedAt(100))
    Assert.assertFalse(statusHandler1.isDefinedAt(200))
    Assert.assertTrue(statusHandler2.isDefinedAt(200))
  }

  @Test def orElse(): Unit = {
    Assert.assertEquals("Huh", statusHandler1.orElse(statusHandler2)(100))
    Assert.assertEquals("Our Error", statusHandler1.orElse(statusHandler2)(500))
  }

}
