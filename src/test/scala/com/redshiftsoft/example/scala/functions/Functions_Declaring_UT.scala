package com.redshiftsoft.example.scala.functions

import org.junit.{Assert, Test}

class Functions_Declaring_UT {

  @Test def declaringNoParams(): Unit = {

    def f0() = 41 + 1

    def f1 = 41 + 1

    def f2 = {
      41 + 1
    }

    def f3: Int = 41 + 1

    def f4: Function0[Int] = new Function0[Int] {
      def apply: Int = 41 + 1
    }

    def f5: () => Int = new Function0[Int] {
      def apply: Int = 41 + 1
    }

    Assert.assertEquals(42, f0)
    Assert.assertEquals(42, f0())
    Assert.assertEquals(42, f1)
    Assert.assertEquals(42, f2)
    Assert.assertEquals(42, f3)
    Assert.assertEquals(42, f4())
    Assert.assertEquals(42, f5())
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

  @Test def declaringByExtending(): Unit = {
    class FooFunction extends (Int => String) {
      def apply(x: Int): String = {
        "somethingFoo" + x
      }
    }
    class BarFunction extends Function1[Int, String] {
      def apply(x: Int): String = {
        "somethingBar" + x
      }
    }

    val fooFunction = new FooFunction
    val barFunction = new BarFunction

    def takesFunction(fun: Int => String, x: Int): String = {
      fun(x)
    }

    Assert.assertEquals("somethingFoo20", takesFunction(fooFunction, 20))
    Assert.assertEquals("somethingBar40", takesFunction(barFunction, 40))
  }


  @Test def declaringWithDefaultValues(): Unit = {
    @annotation.tailrec
    def add(n: Int, sum: Int = 0): Int = {
      if (n < 1) {
        return sum
      }
      add(n - 1, sum + n)
    }

    Assert.assertEquals(800020000, add(n = 40000))
  }

  @Test def declaringWithVarArg(): Unit = {
    def add(n: Int*): Int = {
      var sum = 0
      for (i <- n) sum = sum + i
      sum
    }

    Assert.assertEquals(10, add(1, 2, 3, 4))
  }

  @Test def declaringWithNamedParameters(): Unit = {
    def add(n: Int, sum: Int): Int = {
      if (n < 1) {
        return sum
      }
      add(n - 1, sum + n)
    }

    Assert.assertEquals(800020000, add(sum = 0, n = 40000))
    Assert.assertEquals(800020000, add(n = 40000, sum = 0))
  }

}