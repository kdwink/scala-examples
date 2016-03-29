package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Functions_Partial_UT {

  val statusHandler: Int => String = {
    case 200 => "Okay"
    case 400 => "Error"
    case 500 => "Our Error"
  }

  @Test def partial(): Unit = {
    Assert.assertEquals("Okay", statusHandler(200))
    Assert.assertEquals("Error", statusHandler(400))
    Assert.assertEquals("Our Error", statusHandler(500))
  }

  @Test def partialMatchError(): Unit = {
    var flag: Boolean = false
    try {
      Assert.assertEquals("Our Error", statusHandler(550))
    } catch {
      case e: MatchError =>
        flag = true
    }
    Assert.assertTrue(flag)
  }
}
