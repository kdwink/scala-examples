package com.redshiftsoft.example.scala.functions

import org.junit.{Assert, Test}

class Functions_TailRecursive_UT {

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

}