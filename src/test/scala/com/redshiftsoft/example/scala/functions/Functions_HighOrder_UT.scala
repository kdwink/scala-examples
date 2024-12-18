package com.redshiftsoft.example.scala.functions

import com.redshiftsoft.example.scalatest.BaseSpec
import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

/**
 * Higher order functions take other functions as parameters or return a function as a result.
 *
 * https://docs.scala-lang.org/tour/higher-order-functions.html
 */
class Functions_HighOrder_UT extends BaseSpec {

  "function" should "invoke passed function" in:

    def stringFunc(s: String): Char = s.charAt(2)

    def safeString(s: String, f: String => Char): Char = if s == null then 'z' else f(s)

    assertEquals('c', safeString("abc", stringFunc))
    assertEquals('z', safeString(null, stringFunc))


  "function" should "invoke passed generic function" in:

    def withLock[T](projectId: Int)(f: () => T): T =
      println("got lock for projectId: " + projectId)
      val result = f()
      println("release lock for projectId: " + projectId)
      result

    val xValue = withLock[Int](10) { () =>
      100
    }

    def xFunction(projectId: Int, a: Int, b: Int): Int = withLock[Int](projectId) { () =>
      200 * a - b
    }

    assertEquals(100, xValue)
    assertEquals(4980, xFunction(50, 25, 20))


  "function" should "invoke passed generic no-arg function" in:

    def withLock[T](projectId: Int)(f: => T): T =
      println("got lock for projectId: " + projectId)
      val result = f
      println("release lock for projectId: " + projectId)
      result

    val xValue = withLock[Int](10):
      100

    def xFunction(projectId: Int, a: Int, b: Int): Int = withLock[Int](projectId):
      200 * a - b

    assertEquals(100, xValue)
    assertEquals(4980, xFunction(50, 25, 20))


}