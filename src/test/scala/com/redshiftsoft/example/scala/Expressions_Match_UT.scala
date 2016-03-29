package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Expressions_Match_UT {

  @Test def matchExpression() {
    val x = 100
    val message = x match {
      case 2 | 3 | 7 =>
        "ok"
      case 1 | 4 | 6 =>
        "bad"
      case 100 =>
        println("something")
        println("something else")
        "error"
      case others =>
        "other"
    }
    Assert.assertEquals("error", message)
  }

  @Test def matchExpressionOther(): Unit = {
    val x = 100
    val message = x match {
      case 2 | 3 | 7 =>
        "ok"
      case _ =>
        "could not find case"
    }
    Assert.assertEquals("could not find case", message)
  }

  @Test def matchExpressionOtherWithBindVariable(): Unit = {
    val x = 100
    val message = x match {
      case 2 | 3 | 7 =>
        "ok"
      case somethingOther =>
        s"could not find case for: $somethingOther"
    }
    Assert.assertEquals("could not find case for: 100", message)
  }

  @Test def matchTuples(): Unit = {
    val code = ('h', 204, true) match {
      case (_, _, false) => 501
      case ('c', _, true) => 302
      case ('h', x, true) => x
      case (c, x, true) => -1
    }
    Assert.assertEquals(204, code)
  }

}