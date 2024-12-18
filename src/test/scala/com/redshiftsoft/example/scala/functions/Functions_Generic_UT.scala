package com.redshiftsoft.example.scala.functions

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test


class Functions_Generic_UT {

  @Test def test(): Unit =

    def add[A](x: A, y: A)(implicit numeric: Numeric[A]): A = numeric.plus(x, y)

    assertEquals(9, add(4, 5))
    assertEquals(9L, add(4L, 5L))
    assertEquals(9.9, add(4.4, 5.5), 1e-9)
    assertEquals(9.9f, add(4.4f, 5.5f), 1e-9)


  @Test def tryIt(): Unit =

    def f1(x: Int): List[Int] =
      List(1, 2, 3, x)

    def f2(x: Int): String =
      "hello" + x

    def takesFunction[T](x: Int, func: Int => T): T =
      func(x)

    val result1: List[Int] = takesFunction(10, f1)
    val result2: String = takesFunction(10, f2)

    assertEquals(List(1, 2, 3, 10), result1)
    assertEquals("hello10", result2)


  @Test def identityFunction(): Unit =
    def identity[A](a: A): A = a

    assertEquals("whatever", identity[String]("whatever"))
    assertEquals(42, identity[Int](42))
    assertEquals(0.42, identity[Double](0.42), 1e-9)

    assertEquals("whatever", identity("whatever"))
    assertEquals(42, identity(42))
    assertEquals(0.42, identity(0.42), 1e-9)

}