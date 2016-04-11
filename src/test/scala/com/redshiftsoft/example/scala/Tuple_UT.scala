package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Tuple_UT {

  @Test def declaring(): Unit = {
    val t1 = ("keith", 100, 3.14159)
    val t2: (String, Int, Double) = ("keith", 100, 3.14159)


    for (x <- List(t1, t2)) {
      Assert.assertEquals("keith", x._1)
      Assert.assertEquals(100, x._2)
      Assert.assertEquals(3.14159d, x._3, 1e-9)
    }
  }

  @Test def declarigOperator(): Unit = {
    val x = "keith" -> 2

    Assert.assertEquals("keith", x._1)
    Assert.assertEquals(2, x._2)
  }


}
