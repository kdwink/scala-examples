package com.redshiftsoft.example.scala


import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue, fail}
import org.junit.jupiter.api.Test

import scala.util.{Failure, Success, Try}

/**
 * There two try constructs:
 * <pre>
 * (1) abstract class scala.util.Try
 *
 * (2) object scala.Try
 * </pre>
 */
class Try_UT:

  @Test
  def construction(): Unit = 
    val s: Try[Int] = Success(100)
    val f: Try[Int] = Failure(new AssertionError())

    assertTrue(s.isSuccess)
    assertFalse(s.isFailure)

  @Test
  def constructionWithNull(): Unit = 
    val count: String = null
    val s: Try[String] = Try(count)

    assertFalse(s.isFailure)

  @Test
  def tryWithExpression(): Unit = 
    val theTry: Try[Int] = Try(1 / 0)

    assertTrue(theTry.isFailure)
    assertFalse(theTry.isSuccess)
    assertEquals(classOf[ArithmeticException], theTry.failed.get.getClass)

  @Test def tryWithFunction(): Unit = 

    def loopAndFail(end: Int, failAt: Int): Int =
      for i <- 1 to end do
        if i == failAt then throw new Exception("Too many iterations")
      end

    val trySuccess = util.Try(loopAndFail(5, 9))
    val tryFail = util.Try(loopAndFail(5, 2))

    assertTrue(trySuccess.isSuccess)
    assertEquals(5, trySuccess.get)
    assertTrue(tryFail.isFailure)


  @Test def orElse(): Unit = 
    val inputString = " 123 "
    val inputInt = Try(inputString.toInt).orElse(Try(inputString.trim.toInt))
    assertEquals(123, inputInt.get)

  @Test def getOrElse(): Unit = 
    try
      Try(1 / 0).getOrElse(throw new IllegalStateException())
      fail()
    catch
      case e: IllegalStateException =>

  @Test def matching(): Unit = 
    val theTry: Try[Int] = Failure(new AssertionError())

    val r = theTry match
      case Success(s) =>
        "good:" + s.toString
      case Failure(x) =>
        "bad:" + x.toString

    assertEquals("bad:java.lang.AssertionError", r)

  @Test def map(): Unit = 
    // map failure
    val r1 = Try(throw new IllegalStateException()).map(x => 42)
    assertTrue(r1.isFailure)
    assertTrue(r1.failed.get.isInstanceOf[IllegalStateException])

    // map success
    val r2 = Try(1 + 1).map(x => 2000)
    assertEquals(2000, r2.get)

    // map with partial matching case statements
    val r3 = Try(1 + 1).map:
      case 20 => 4000
      case 30 => 3000
    assertTrue(r3.isFailure)
    assertTrue(r3.failed.get.isInstanceOf[MatchError])

    // map with partial matching case statements
    val r4 = Try(1 + 1).map:
      case 2 => throw new IllegalStateException("x y z")
      case 3 => 3000
    assertTrue(r4.isFailure)
    assertEquals(r4.failed.get.getMessage, "x y z")

  