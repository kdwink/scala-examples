package com.redshiftsoft.example.scala.collections.monadic

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test


class Either_UT:

  @Test def right(): Unit =
    val valueR: Either[String, Thing] = getValue(23)
    // then
    assertTrue(valueR.isRight)
    assertEquals(T, valueR.getOrElse(1))
    assertTrue(valueR.contains(T))
    assertTrue(valueR.exists(_ == T))
    assertTrue(valueR.toOption.isDefined)

  @Test def left(): Unit =
    val valueL: Either[String, Thing] = getValue(123)
    // then
    assertTrue(valueL.isLeft)
    assertTrue(valueL.toOption.isEmpty)
    assertFalse(valueL.exists(_ == T))

  // - - - - - - - - - - - - - - - - - - - - -

  case class Thing(name: String, age: Long)

  private val T: Thing = Thing("john", 25)

  def getValue(arg: Long): Either[String, Thing] =
    if arg < 100 then
      Right(T)
    else
      Left("bad")

