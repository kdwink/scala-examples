package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Functions_Generic_UT {

  @Test def test(): Unit = {

    def add[A](x: A, y: A)(implicit numeric: Numeric[A]): A = numeric.plus(x, y)

    Assert.assertEquals(9, add(4, 5))
    Assert.assertEquals(9L, add(4L, 5L))
    Assert.assertEquals(9.9, add(4.4, 5.5), 1e-9)
    Assert.assertEquals(9.9f, add(4.4f, 5.5f), 1e-9)
  }


}