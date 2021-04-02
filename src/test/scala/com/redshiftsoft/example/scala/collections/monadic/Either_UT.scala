package com.redshiftsoft.example.scala.collections.monadic

import org.junit.{Assert, Test}

class Either_UT {

  @Test def right(): Unit = {
    val valueR: Either[String, Thing] = getValue(23)
    // then
    Assert.assertTrue(valueR.isRight)
    Assert.assertEquals(T, valueR.getOrElse(1))
    Assert.assertTrue(valueR.contains(T))
  }

  @Test def left(): Unit = {
    val valueL: Either[String, Thing] = getValue(123)
    // then
    Assert.assertTrue(valueL.isLeft)
  }

  // - - - - - - - - - - - - - - - - - - - - -

  case class Thing(name: String, age: Long)

  private val T: Thing = Thing("john", 25)

  def getValue(arg: Long): Either[String, Thing] = {
    if (arg < 100)
      Right(T)
    else
      Left("bad")
  }
}

