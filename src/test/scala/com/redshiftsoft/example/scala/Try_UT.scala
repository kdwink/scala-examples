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
  def construction(): Unit = {
    val s: Try[Int] = Success(100)
    val f: Try[Int] = Failure(new AssertionError())

    Assert.assertTrue(s.isSuccess)
    Assert.assertFalse(s.isFailure)
  }

  @Test
  def tryWithFunction(): Unit = {
    val theTry: Try[Int] = Try(1 / 0)

    Assert.assertTrue(theTry.isFailure)
    Assert.assertFalse(theTry.isSuccess)
    Assert.assertEquals(classOf[ArithmeticException], theTry.failed.get.getClass)
  }

  @Test def getOrElse(): Unit = {
    try {
      Try(1 / 0).getOrElse(throw new IllegalStateException())
      Assert.fail()
    } catch {
      case e: IllegalStateException =>
    }
  }

  @Test
  def matching(): Unit = {
    val theTry: Try[Int] = Failure(new AssertionError())

    val r = theTry match {
      case Success(s) =>
        "good:" + s.toString
      case Failure(x) =>
        "bad:" + x.toString
    }

    Assert.assertEquals("bad:java.lang.AssertionError", r)
  }

  def failure() : Unit = {
    val theTry: Try[Int] = Failure()
  }

}