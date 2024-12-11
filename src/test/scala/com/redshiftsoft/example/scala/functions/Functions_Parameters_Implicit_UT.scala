package com.redshiftsoft.example.scala.functions

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test


class Functions_Parameters_Implicit_UT {


  @Test def implicitParameterGroup(): Unit = {

    def f(x: Int, y: Int)(implicit z: Int) = x + y * z

    implicit val someVal1: Int = 100

    assertEquals(7, f(1, 2)(3))
    assertEquals(7, f(1, 2)(3))
    assertEquals(201, f(1, 2))
  }

}
