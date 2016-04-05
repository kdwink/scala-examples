package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

import scala.concurrent.Promise

class Promise_UT {

  @Test
  def failed(): Unit = {
    val prom: Promise[Int] = Promise.failed(new Throwable)

    Assert.assertTrue(prom.isCompleted)
    Assert.assertTrue(prom.future.value.get.isFailure)
  }

  @Test
  def successful(): Unit = {
    val prom: Promise[Int] = Promise.successful(20)

    Assert.assertTrue(prom.isCompleted)
    Assert.assertTrue(prom.future.value.get.isSuccess)
    Assert.assertEquals(20, prom.future.value.get.get)
  }


}
