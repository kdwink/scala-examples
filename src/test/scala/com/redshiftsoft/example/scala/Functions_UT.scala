package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Functions_UT {

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