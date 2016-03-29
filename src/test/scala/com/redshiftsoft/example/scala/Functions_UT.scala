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
    def f7(x: Int, y: Int): Int = x + y
    def f8(x: Int, y: Int): Int = {
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

  @Test
  def tailRecursiveDoNotStackOverflow(): Unit = {
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

  @Test
  def namedParameters(): Unit = {
    @annotation.tailrec
    def add(n: Int, sum: Int): Int = {
      if (n < 1) {
        return sum
      }
      add(n - 1, sum + n)
    }
    Assert.assertEquals(800020000, add(sum = 0, n = 40000))
  }

  @Test
  def defaultValues(): Unit = {
    @annotation.tailrec
    def add(n: Int, sum: Int = 0): Int = {
      if (n < 1) {
        return sum
      }
      add(n - 1, sum + n)
    }
    Assert.assertEquals(800020000, add(n = 40000))
  }

  @Test
  def varArg(): Unit = {
    def add(n: Int*): Int = {
      var sum = 0
      for (i <- n) sum = sum + i
      sum
    }
    Assert.assertEquals(10, add(1, 2, 3, 4))
  }


}
