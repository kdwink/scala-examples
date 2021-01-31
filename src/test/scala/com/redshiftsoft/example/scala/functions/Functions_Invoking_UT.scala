package com.redshiftsoft.example.scala.functions

import org.junit.{Assert, Test}

class Functions_Invoking_UT {

  @Test def invokeWithOperatorNotation(): Unit = {
    Assert.assertEquals("eith", "Keith" substring 1)
    Assert.assertEquals("ei", "Keith" substring(1, 3))
  }

  @annotation.nowarn
  @Test def withAndWithoutParenthesis(): Unit = {
    def accessDBFunc(): Int = 20

    Assert.assertEquals(20, accessDBFunc)
    Assert.assertEquals(20, accessDBFunc())
  }

  @Test def withApply(): Unit = {

    val doubler1: Int => Int = (i: Int) => i * 2

    def doubler2(i: Int): Int = i * 2

    def invokeIt[T](f: Int => T): T = f(8)

    Assert.assertEquals(14, doubler1(7))
    Assert.assertEquals(14, doubler2(7))

    Assert.assertEquals(16, invokeIt(doubler1))
    Assert.assertEquals(16, invokeIt(doubler2))

    Assert.assertEquals(14, doubler1.apply(7))
    //Assert.assertEquals(14, doubler2.apply(7))

  }

}