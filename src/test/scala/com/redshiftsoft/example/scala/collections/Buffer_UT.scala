package com.redshiftsoft.example.scala.collections

import org.junit.{Assert, Test}

class Buffer_UT {

  @Test def go(): Unit = {

    val nums = collection.mutable.Buffer(1, 2, 3)
    Assert.assertEquals(3, nums.size)

    for (i <- 1 to 100) nums += i
    Assert.assertEquals(103, nums.size)

  }

}
