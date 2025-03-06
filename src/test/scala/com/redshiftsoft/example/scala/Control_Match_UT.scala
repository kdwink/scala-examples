package com.redshiftsoft.example.scala

import org.junit.*
import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test


/**
 * Pattern Matching: https://docs.scala-lang.org/tour/pattern-matching.html
 *
 * There is no "fall through" in the matching cases, one and only one case statement is executed.
 * If multiple case conditions match, the first is executed.
 */
class Control_Match_UT:

  @Test def match_simple(): Unit =
    val x = 100
    val message = x match
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
    assertEquals("error", message)

  @Test def match_with_guard(): Unit =
    val x = Option(9)
    val message = x match
      case Some(x) if x < 10 =>
        "case 1"
      case Some(y) if y < 100 =>
        "case 2"
      case others =>
        "case 3"
    assertEquals("case 1", message)

  // This is possible.
  @Test def match_with_guard_only(): Unit =
    val x = Option(90)
    val y = 10
    val message = x match
      case _ if x.get < 10 =>
        "case 1"
      case _ if y < 100 =>
        "case 2"
      case _ =>
        "case 3"
    assertEquals("case 2", message)

  @Test def match_class(): Unit =
    val x: Any = ""
    val message = x match
      case _: Int =>
        "case 1"
      case _: String =>
        "case 2"
      case others =>
        "case 3"
    assertEquals("case 2", message)

  @Test def match_other(): Unit =
    val x = 100
    val message = x match
      case 2 | 3 | 7 =>
        "ok"
      case _ =>
        "could not find case"
    assertEquals("could not find case", message)

  @Test def matchE_OtherWithBindVariable(): Unit =
    val x = 100
    val message = x match
      case 2 | 3 | 7 =>
        "ok"
      case somethingOther =>
        s"could not find case for: $somethingOther"
    assertEquals("could not find case for: 100", message)

  @Test def matchTuples(): Unit =
    val code = ('h', 204, true) match
      case (_, _, false) => 501
      case ('c', _, true) => 302
      case ('h', x, true) => x
      case (c, x, true) => -1
    assertEquals(204, code)

  @annotation.nowarn
  @Test def matchingOption_withShadowingInPatternMatching(): Unit =
    // cautionary tale
    val someValue = 100
    val code = Some(3) match
      case Some(someValue) =>
        "but get this because of shadowing: " + someValue
      case Some(3) =>
        "expect this"
      case _ => "other"
    assertEquals("but get this because of shadowing: 3", code)

  @Test def matchingOption_wtfScalaVariableCaseAffectsLogic(): Unit =
    val SomeValue = 100
    val code = Some(3) match
      case Some(SomeValue) =>
        "but get this because of shadowing: " + SomeValue
      case Some(3) =>
        "expect this"
      case _ => "other"
    assertEquals("expect this", code)


