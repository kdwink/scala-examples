package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Literals_UT {

  @Test def floatingPoint(): Unit = {
    val x = 2.333333333333333d
    val y = 2.333333333333333
    val z = 2.333333333333333f


    assertEquals("2.333333333333333", x.toString)
    assertEquals("2.333333333333333", y.toString)
    assertEquals("2.3333333", z.toString)
  }

  @Test def integers(): Unit = {
    val x = 123456789
    assertEquals(123456789, x)

    val aLong = 8000000000L
    assertEquals(8000000000L, aLong)
  }

  @Test def integers_hex(): Unit = {
    val x = 0xfff
    assertEquals(4095, x)
  }

  //noinspection TypeAnnotation
  @Test def unit(): Unit = {
    val x = ()
    val y: Unit = ()
    assertEquals(x, y)
  }

  @Test def tuple(): Unit = {
    val threeTuple = (1, 2, "whatever")
    assertEquals((1, 2, "whatever"), threeTuple)

    val twoTuple1 = (100, "whatever")
    val twoTuple2 = 100 -> "whatever"
    assertEquals(twoTuple1, twoTuple2)
  }

  @Test
  def regex(): Unit = {
    val regex = "\\d+".r
    val in: Option[String] = regex.findFirstIn("whatever 435")
    assertEquals("435", in.get)
  }

}