package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Functions_UT {

  @Test
  def declaring(): Unit = {

    def f0() = "String"
    def f1 = "String"
    def f2 = 5

    def f3(x: Int) = 5

    def f4(x: Int) = 2 + x
    def f5(x: Int, y: Int) = x + y
    def f6(x: Int, y: Int) = {
      x + y
    }
    def f7(x: Int, y: Int) : Int = x + y
    def f8(x: Int, y: Int) : Int = {
      x + y
    }

    Assert.assertEquals("String", f0)
    Assert.assertEquals("String", f0())
    Assert.assertEquals("String", f1)
    Assert.assertEquals(5, f2)
    Assert.assertEquals(5, f3(0))

    Assert.assertEquals(12, f4(10))
    Assert.assertEquals(21, f5(10, 11))
    Assert.assertEquals(21, f6(10, 11))
    Assert.assertEquals(21, f7(10, 11))
    Assert.assertEquals(21, f8(10, 11))

  }

}
