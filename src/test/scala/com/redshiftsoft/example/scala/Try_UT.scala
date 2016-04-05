package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

import scala.util.{Failure, Success, Try}

/**
  * There two try constructs:
  * <pre>
  * (1) abstract class scala.util.Try
  *
  * (2) object scala.Try
  * </pre>
  */
class Try_UT {

  @Test
  def test(): Unit = {
    val s: Try[Int] = Success(100)
    val f: Try[Int] = Failure(new AssertionError())

    Assert.assertTrue(s.isSuccess)
    Assert.assertFalse(s.isFailure)
  }

  @Test
  def tryWithFunction(): Unit = {
    val f: Try[Int] = Try(1 / 0)

    Assert.assertTrue(f.isFailure)
    Assert.assertFalse(f.isSuccess)
    Assert.assertEquals(classOf[ArithmeticException], f.failed.get.getClass)
  }


}
