package com.redshiftsoft.example.scala.functions

import org.junit.{Assert, Test}

class Functions_Parameters_Implicit_UT {


  @Test def parameterGrouping(): Unit = {

    def f(x: Int, y: Int)(implicit z: Int) = x + y * z

    implicit val someVal1: Int = 100

    Assert.assertEquals(7, f(1, 2)(3))
    Assert.assertEquals(7, f(1, 2)(3))
    Assert.assertEquals(201, f(1, 2))
  }

}
