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
  def constructionWithNull(): Unit = {
    val count: String = null
    val s: Try[String] = Try(count)

    Assert.assertFalse(s.isFailure)
  }

  @Test
  def tryWithExpression(): Unit = {
    val theTry: Try[Int] = Try(1 / 0)

    Assert.assertTrue(theTry.isFailure)
    Assert.assertFalse(theTry.isSuccess)
    Assert.assertEquals(classOf[ArithmeticException], theTry.failed.get.getClass)
  }

  @Test def tryWithFunction(): Unit = {

    def loopAndFail(end: Int, failAt: Int): Int = {
      for (i <- 1 to end) {
        if (i == failAt) throw new Exception("Too many iterations")
      }
      end
    }

    val trySuccess = util.Try(loopAndFail(5, 9))
    val tryFail = util.Try(loopAndFail(5, 2))

    Assert.assertTrue(trySuccess.isSuccess)
    Assert.assertEquals(5, trySuccess.get)
    Assert.assertTrue(tryFail.isFailure)

  }


  @Test def orElse(): Unit = {
    val inputString = " 123 "
    val inputInt = Try(inputString.toInt).orElse(Try(inputString.trim.toInt))
    Assert.assertEquals(123, inputInt.get)
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

}