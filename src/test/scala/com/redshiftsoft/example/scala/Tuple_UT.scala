package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Tuple_UT {

  @Test def tuple(): Unit = {
    val x = ("keith", 2, 3.14159)
    Assert.assertEquals("keith", x._1)
    Assert.assertEquals(2, x._2)
    Assert.assertEquals(3.14159d, x._3, 1e-9)
  }

  @Test def tuple2(): Unit = {
    val x = "keith" -> 2
    Assert.assertEquals("keith", x._1)
    Assert.assertEquals(2, x._2)
  }


}
