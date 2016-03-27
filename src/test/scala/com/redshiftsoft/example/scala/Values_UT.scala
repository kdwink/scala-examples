package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Values_UT {

  @Test
  def declaring(): Unit = {

    val x1 = 20
    val y1 = "abcd"
    val z1 = 'c'

    val x2: Int = 20
    val y2: String = "abcd"
    val z2: Char = 'c'

    Assert.assertEquals(x1, x2)
    Assert.assertEquals(y1, y2)
    Assert.assertEquals(z1, z2)
  }


}
