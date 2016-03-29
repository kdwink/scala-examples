package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Functions_Reference_UT {

  @Test def functionReference(): Unit = {
    def literal() = "whatever"
    def double(x: Int): Int = 2 * x
    def sum(x: Int, y: Int): Int = x + y


    val literalPointer: () => String = literal
    val doublePointer1: Int => Int = double
    val doublePointer2: (Int) => Int = double
    val doublePointer3 = double _

    val sumPointer1: (Int, Int) => Int = sum
    val sumPointer2 = sum _

    Assert.assertEquals("whatever", literalPointer())

    Assert.assertEquals(10, doublePointer1(5))
    Assert.assertEquals(10, doublePointer2(5))
    Assert.assertEquals(10, doublePointer3(5))

    Assert.assertEquals(11, sumPointer1(5, 6))
    Assert.assertEquals(11, sumPointer2(5, 6))
  }

  @Test def refToAnonymousFunctionLiteral(): Unit = {
    val doubler1 = (x: Int) => x * 2
    Assert.assertEquals(100, doubler1(50))
  }

  @Test def placeholder(): Unit = {
    val doubler: Int => Int = _ * 2
    Assert.assertEquals(100, doubler(50))

    val subtractFunc: (Int, Int) => Int = _ - _
    Assert.assertEquals(49, subtractFunc(50, 1))
    Assert.assertEquals(-49, subtractFunc(1, 50))
  }


}