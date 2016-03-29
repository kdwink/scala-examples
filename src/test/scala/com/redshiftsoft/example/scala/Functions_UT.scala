package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Functions_UT {

  @Test def declaringNoParams(): Unit = {
    def f0() = "String"
    def f1 = "String"
    def f2 = 5
    def f3 = {
      9
    }
    def f4: Int = 19 - 11

    Assert.assertEquals("String", f0)
    Assert.assertEquals("String", f0())
    Assert.assertEquals("String", f1)
    Assert.assertEquals(5, f2)
    Assert.assertEquals(9, f3)
    Assert.assertEquals(8, f4)
  }

  @Test def declaringWithParams(): Unit = {

    def f3(x: Int) = 5

    def f4(x: Int) = 2 + x
    def f5(x: Int, y: Int) = x + y
    def f6(x: Int, y: Int) = {
      x + y
    }
    def f7(x: Int, y: Int): Int = x + y
    def f8(x: Int, y: Int): Int = {
      x + y
    }

    Assert.assertEquals(5, f3(0))

    Assert.assertEquals(12, f4(10))
    Assert.assertEquals(21, f5(10, 11))
    Assert.assertEquals(21, f6(10, 11))
    Assert.assertEquals(21, f7(10, 11))
    Assert.assertEquals(21, f8(10, 11))

  }

  @Test def tailRecursiveDoNotStackOverflow(): Unit = {
    @annotation.tailrec
    def add(n: Int, sum: Int): Int = {
      if (n < 1) {
        return sum
      }
      add(n - 1, sum + n)
    }
    Assert.assertEquals(10, add(4, 0))
    Assert.assertEquals(80200, add(400, 0))
    Assert.assertEquals(800020000, add(40000, 0))
  }

  @Test def namedParameters(): Unit = {
    @annotation.tailrec
    def add(n: Int, sum: Int): Int = {
      if (n < 1) {
        return sum
      }
      add(n - 1, sum + n)
    }
    Assert.assertEquals(800020000, add(sum = 0, n = 40000))
  }

  @Test def defaultValues(): Unit = {
    @annotation.tailrec
    def add(n: Int, sum: Int = 0): Int = {
      if (n < 1) {
        return sum
      }
      add(n - 1, sum + n)
    }
    Assert.assertEquals(800020000, add(n = 40000))
  }

  @Test def varArg(): Unit = {
    def add(n: Int*): Int = {
      var sum = 0
      for (i <- n) sum = sum + i
      sum
    }
    Assert.assertEquals(10, add(1, 2, 3, 4))
  }

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

}