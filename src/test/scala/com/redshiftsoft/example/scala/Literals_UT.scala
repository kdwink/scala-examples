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

}
