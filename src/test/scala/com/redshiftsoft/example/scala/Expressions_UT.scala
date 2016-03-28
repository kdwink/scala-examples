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

  @Test
  def ifElse(): Unit = {
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

  @Test
  def matchExpression() {
    val x = 100
    val message = x match {
      case 2 | 3 | 7 =>
        "ok"
      case 1 | 4 | 6 =>
        "bad"
      case 100 =>
        println("somethign")
        println("somethign else")
        "error"
      case others =>
        "other"
    }
    Assert.assertEquals("error", message)
  }


  @Test
  def matchExpressionOther(): Unit = {
    val x = 100
    val message = x match {
      case 2 | 3 | 7 =>
        "ok"
      case _ =>
        "could not find case"
    }
    Assert.assertEquals("could not find case", message)
  }

  @Test
  def matchExpressionOtherWithBindVariable(): Unit = {
    val x = 100
    val message = x match {
      case 2 | 3 | 7 =>
        "ok"
      case somethingOther =>
        s"could not find case for: ${somethingOther}"
    }
    Assert.assertEquals("could not find case for: 100", message)
  }






}
