package com.redshiftsoft.example.scala.functions

import org.junit.{Assert, Test}

class Functions_UT {

  @Test def typeParameter(): Unit = {
    def identity[A](a: A): A = a

    Assert.assertEquals("whatever", identity[String]("whatever"))
    Assert.assertEquals(42, identity[Int](42))
    Assert.assertEquals(0.42, identity[Double](0.42), 1e-9)

    Assert.assertEquals("whatever", identity("whatever"))
    Assert.assertEquals(42, identity(42))
    Assert.assertEquals(0.42, identity(0.42), 1e-9)
  }

  @Test def invokeWithOperatorNotation(): Unit = {
    Assert.assertEquals("eith", "Keith" substring 1)
    Assert.assertEquals("ei", "Keith" substring(1, 3))
  }

  @Test def byNameParameter(): Unit = {
    def accessDBFunc(): Int = 20
    def triple(x: => Int) = 3 * x

    Assert.assertEquals(20, accessDBFunc)
    Assert.assertEquals(15, triple(5))
    Assert.assertEquals(60, triple(accessDBFunc))
  }

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