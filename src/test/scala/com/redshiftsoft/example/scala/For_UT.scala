package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class For_UT {

  @Test def forOneToOne(): Unit = {
    var count = 0
    for(_ <- 1 to 1) {
      count = count + 1
    }
    Assert.assertEquals(1, count)
  }

}