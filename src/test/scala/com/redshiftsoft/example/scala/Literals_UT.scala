package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Literals_UT {

  @Test
  def floatingPoint() {
    val x = 2.333333333333333d
    val y = 2.333333333333333
    val z = 2.333333333333333f


    Assert.assertEquals("2.333333333333333", x.toString)
    Assert.assertEquals("2.333333333333333", y.toString)
    Assert.assertEquals("2.3333333", z.toString)
  }

  @Test
  def integers() {
    val x = 123456789
    Assert.assertEquals(123456789, x)

    val aLong = 8000000000L
    Assert.assertEquals(8000000000L, aLong)
  }

  @Test
  def integers_hex() {
    val x = 0xfff
    Assert.assertEquals(4095, x)
  }

  @Test
  def unit(): Unit = {
    val x = ()
    val y: Unit = ()
    Assert.assertEquals(x, y)
  }

  @Test def tuple(): Unit = {
    val x = (1, 2, "whatever")
    Assert.assertEquals((1, 2, "whatever"), x);
  }


}
