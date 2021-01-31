package com.redshiftsoft.example.scala

import org.junit.Assert._
import org.junit.Test

class Expressions_Match_UT {

  @Test def matchExpression(): Unit = {
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
    assertEquals("error", message)
  }

  @Test def matchExpressionOther(): Unit = {
    val x = 100
    val message = x match {
      case 2 | 3 | 7 =>
        "ok"
      case _ =>
        "could not find case"
    }
    assertEquals("could not find case", message)
  }

  @Test def matchExpressionOtherWithBindVariable(): Unit = {
    val x = 100
    val message = x match {
      case 2 | 3 | 7 =>
        "ok"
      case somethingOther =>
        s"could not find case for: $somethingOther"
    }
    assertEquals("could not find case for: 100", message)
  }

  @Test def matchTuples(): Unit = {
    val code = ('h', 204, true) match {
      case (_, _, false) => 501
      case ('c', _, true) => 302
      case ('h', x, true) => x
      case (c, x, true) => -1
    }
    assertEquals(204, code)
  }

  @annotation.nowarn
  @Test def matchingOption_withShadowingInPatternMatching(): Unit = {
    // cautionary tale
    val someValue = 100
    val code = Some(3) match {
      case Some(someValue) =>
        "but get this because of shadowing: " + someValue
      case Some(3) =>
        "expect this"
      case _ => "other"
    }
    assertEquals("but get this because of shadowing: 3", code)
  }

  @Test def matchingOption_wtfScalaVariableCaseAffectsLogic(): Unit = {
    val SomeValue = 100
    val code = Some(3) match {
      case Some(SomeValue) =>
        "but get this because of shadowing: " + SomeValue
      case Some(3) =>
        "expect this"
      case _ => "other"
    }
    assertEquals("expect this", code)
  }


}