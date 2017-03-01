package com.redshiftsoft.example.scala.functions

import org.junit.{Assert, Test}

class Functions_Methods_UT {

  @Test def andThen(): Unit = {
    val doubler = (i: Int) => i * 2
    val plus3 = (i: Int) => i + 3
    Assert.assertEquals(203, (doubler andThen plus3) (100))
  }

  @Test def compose(): Unit = {
    val doubler = (i: Int) => i * 2
    val plus3 = (i: Int) => i + 3
    Assert.assertEquals(206, (doubler compose plus3) (100))
  }

}