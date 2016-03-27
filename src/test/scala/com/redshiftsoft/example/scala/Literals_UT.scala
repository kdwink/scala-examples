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
  def integers(): Unit = {
    val x = 123456789
    Assert.assertEquals(123456789, x)

    val aLong = 8000000000L;
    Assert.assertEquals(8000000000L, aLong)
  }


}
