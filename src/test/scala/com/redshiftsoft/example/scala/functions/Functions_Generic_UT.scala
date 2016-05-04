package com.redshiftsoft.example.scala.functions

import org.junit.{Assert, Test}

class Functions_Generic_UT {

  @Test def test(): Unit = {

    def add[A](x: A, y: A)(implicit numeric: Numeric[A]): A = numeric.plus(x, y)

    Assert.assertEquals(9, add(4, 5))
    Assert.assertEquals(9L, add(4L, 5L))
    Assert.assertEquals(9.9, add(4.4, 5.5), 1e-9)
    Assert.assertEquals(9.9f, add(4.4f, 5.5f), 1e-9)
  }


  @Test def tryIt(): Unit = {

    def f1(x: Int): List[Int] = {
      List(1, 2, 3, x)
    }
    def f2(x: Int): String = {
      "hello" + x
    }

    def takesFunction[T](x: Int, func: Int => T): T = {
      func(x)
    }

    val result1: List[Int] = takesFunction(10, f1)
    val result2: String = takesFunction(10, f2)

    Assert.assertEquals(List(1, 2, 3, 10), result1)
    Assert.assertEquals("hello10", result2)

  }

}