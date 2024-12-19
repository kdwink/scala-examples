package com.redshiftsoft.example.scala.traits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Traits_Stack_UT:

  @Test def test1(): Unit =
    // given
    val stuff = new RealStuff

    // then
    assertEquals("real stuff", stuff.doStuff())

  @Test def test_loggable(): Unit =
    // given
    val stuff = new RealStuff with LoggableStuff

    // then
    assertEquals("loggable real stuff", stuff.doStuff())

  @Test def test_transaction(): Unit =
    // given
    val stuff = new RealStuff with TransactionalStuff

    // then
    assertEquals("transaction real stuff", stuff.doStuff())

  @Test def test_transaction_loggable(): Unit =
    // given
    val stuff = new RealStuff with LoggableStuff with TransactionalStuff

    // then
    assertEquals("transaction loggable real stuff", stuff.doStuff())

  @Test def test_loggable_transaction(): Unit =
    // given
    val stuff = new RealStuff with TransactionalStuff with LoggableStuff

    // then
    assertEquals("loggable transaction real stuff", stuff.doStuff())


  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  //
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  trait Stuff:
    def doStuff(): String = "default stuff"

  trait LoggableStuff extends Stuff:
    abstract override def doStuff(): String = 
      "loggable " + super.doStuff()

  trait TransactionalStuff extends Stuff:
    abstract override def doStuff(): String =
      try
        "transaction " + super.doStuff()
      catch
        case e: Exception =>
          "exception happened"

  class RealStuff extends Stuff:
    override def doStuff(): String = "real stuff"
