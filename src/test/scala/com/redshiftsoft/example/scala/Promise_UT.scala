package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

import scala.concurrent.Promise

class Promise_UT {

  @Test
  def failed(): Unit = {
    val prom: Promise[Int] = Promise.failed(new Throwable)

    assertTrue(prom.isCompleted)
    assertTrue(prom.future.value.get.isFailure)
  }

  @Test
  def successful(): Unit = {
    val prom: Promise[Int] = Promise.successful(20)

    assertTrue(prom.isCompleted)
    assertTrue(prom.future.value.get.isSuccess)
    assertEquals(20, prom.future.value.get.get)
  }


}
