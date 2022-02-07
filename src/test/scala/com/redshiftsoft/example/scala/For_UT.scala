package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class For_UT {

  @Test def forOneToOne(): Unit = {
    var count = 0
    for (x <- 1 to 10) {
      count = count + x
    }
    Assert.assertEquals(55, count)
  }

}
