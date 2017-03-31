package com.redshiftsoft.example.scala.functions

import org.junit.{Assert, Test}

class Functions_TailRecursive_UT {

  @Test def tailRecursiveDoNotStackOverflow(): Unit = {

    @annotation.tailrec
    def add(n: Long, sum: Long): Long = {
      if (n < 1L) {
        return sum
      }
      add(n - 1L, sum + n)
    }

    Assert.assertEquals(10L, add(4, 0))
    Assert.assertEquals(80200L, add(400, 0))
    Assert.assertEquals(800020000L, add(40 * 1000, 0))
    Assert.assertEquals(8000002000000L, add(4 * 1000 * 1000, 0))
  }

}