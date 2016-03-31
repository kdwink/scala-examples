package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class TryCollections_UT {

  @Test def simple(): Unit = {
    val inputString = " 123 "
    val inputInt = util.Try(inputString.toInt).orElse(util.Try(inputString.trim.toInt))
    Assert.assertEquals(123, inputInt.get)
  }


  @Test def tryCollections(): Unit = {

    def loopAndFail(end: Int, failAt: Int): Int = {
      for (i <- 1 to end) {
        if (i == failAt) throw new Exception("Too many iterations")
      }
      end
    }
    val trySuccess = util.Try(loopAndFail(5, 9))
    val tryFail = util.Try(loopAndFail(5, 2))

    Assert.assertTrue(trySuccess.isSuccess)
    Assert.assertTrue(tryFail.isFailure)

  }

}
