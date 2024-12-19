package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * https://docs.scala-lang.org/scala3/book/control-structures.html#trycatchfinally
 */
class Control_Try_Catch_Finally_UT:

  @Test def try_catch(): Unit =
    var s = ""
    try
      throw new NullPointerException()
    catch
      case e: NullPointerException =>
        s = "npe"
      case e2: Throwable =>
        s = "throwable"

    assertEquals("npe", s)

  @Test def try_catch_finally(): Unit =
    var s = ""

    try
      throw new NullPointerException()
    catch
      case e: NullPointerException =>
    finally
      s = "finally"

    assertEquals("finally", s)
