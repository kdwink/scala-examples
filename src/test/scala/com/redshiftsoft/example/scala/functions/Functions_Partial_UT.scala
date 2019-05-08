package com.redshiftsoft.example.scala.functions

import org.junit.{Assert, Test}

import scala.util.Try

class Functions_Partial_UT {

  private val statusHandler1: PartialFunction[Int, String] = {
    case 100 => "Huh"
  }

  private val statusHandler2: PartialFunction[Int, String] = {
    case 200 => "Okay"
    case 400 => "Error"
    case 500 => "Our Error"
  }

  @Test def invokeDirectly(): Unit = {
    Assert.assertEquals("Okay", statusHandler2(200))
    Assert.assertEquals("Error", statusHandler2(400))
    Assert.assertEquals("Our Error", statusHandler2(500))
  }

  @Test def partialMatchError(): Unit = {
    var flag: Boolean = false
    try {
      Assert.assertEquals("Our Error", statusHandler2(550))
    } catch {
      case e: MatchError =>
        flag = true
    }
    Assert.assertTrue(flag)
  }

  //noinspection AccessorLikeMethodIsUnit
  @Test def isDefinedAt(): Unit = {
    Assert.assertTrue(statusHandler1.isDefinedAt(100))
    Assert.assertFalse(statusHandler1.isDefinedAt(200))
    Assert.assertTrue(statusHandler2.isDefinedAt(200))
  }

  @Test def orElse(): Unit = {
    Assert.assertEquals("Huh", statusHandler1.orElse(statusHandler2)(100))
    Assert.assertEquals("Our Error", statusHandler1.orElse(statusHandler2)(500))
  }

  /** collect will filter stream to only elements on which partial function is defined. */
  @Test def useWithCollect(): Unit = {
    // given
    def stringify: PartialFunction[Int, String] = {
      case 10 => "ten"
      case 20 => "twenty"
      case 100 => "hundred"
    }
    // when/then
    Assert.assertEquals("List(ten, twenty, hundred)", Seq(10, 20, 30, 40, 50, 60, 100).collect(stringify).toString)
  }

  /** collect will filter stream to only elements on which partial function is defined. */
  @Test def useWithMap(): Unit = {
    // given
    def stringify: PartialFunction[Int, String] = {
      case 10 => "ten"
      case 20 => "twenty"
    }
    // when
    val theTry = Try(Seq(1, 2).map(stringify))

    // then
    Assert.assertFalse(theTry.isSuccess)
    Assert.assertTrue(theTry.failed.get.isInstanceOf[MatchError])
  }


  @Test def useWithTry(): Unit = {
    def handleError: PartialFunction[Throwable, Int] = {
      case t: IllegalStateException =>
        111
      case t: Throwable =>
        222
    }

    def errorMethod(): String = {
      throw new IllegalStateException()
    }

    val theTry = Try(errorMethod())
    Assert.assertTrue(theTry.isFailure)
    val recoveredTry = theTry.recover(handleError)
    Assert.assertTrue(recoveredTry.isSuccess)
    Assert.assertEquals(111, recoveredTry.get)
  }


}
