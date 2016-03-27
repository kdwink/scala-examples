package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Values_UT {

  @Test
  def declaring(): Unit = {

    val x = 20
    val y: Int = 20

    Assert.assertEquals(x, y)
  }


}
