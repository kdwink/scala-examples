package com.redshiftsoft.example.scala.collections.monadic

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

import java.util.concurrent.atomic.LongAdder


class Option_UT:

  //noinspection ScalaUnusedExpression
  @Test def get(): Unit =
    val none: Option[String] = None
    try
      none.get
      fail()
    catch
      case e: NoSuchElementException =>

  @Test def constructWithNull(): Unit =
    val option = Option(null)
    assertTrue(option.isEmpty)
    assertFalse(option.isDefined)

  @Test def constructSomeWithNull(): Unit =
    val option = Some[String](null)
    assertTrue(option.isDefined)
    assertFalse(option.isEmpty)

  @Test def none(): Unit =
    val none: Option[String] = None
    assertTrue(none.isEmpty)
    assertFalse(none.isDefined)

  @Test def getOrElse(): Unit =
    val none: Option[String] = None
    assertEquals(100, none.getOrElse(100))

  /* passing lazy value to getOrElse does NOT cause lazy to be evaluated */
  @Test def getOrElseWithLazyArg(): Unit =
    val longAdder = new LongAdder

    def expensiveFunction(x: Int): Int =
      println("EXPENSIVE")
      longAdder.add(100)
      42 * x

    lazy val alternate = expensiveFunction(10)
    val option: Option[Int] = Some(50)
    assertEquals(50, option.getOrElse(alternate))
    assertEquals(0, longAdder.longValue())

  @Test
  def getOrElseThrow(): Unit =
    assertThrows(classOf[IllegalStateException], () => {
      val none = None
      none.getOrElse(throw new IllegalStateException())
    })

  @Test def option(): Unit =
    var x: String = "stuff"
    val option = Option(x)
    assertFalse(option.isEmpty)
    assertTrue(option.isDefined)

    /* Changing x doesn't change the options */
    x = null
    assertFalse(option.isEmpty)
    assertTrue(option.isDefined)

  @Test def optionalArithmeticResult(): Unit =
    def divide(n: Double, d: Double): Option[Double] =
      if d == 0 then None
      else Option(n / d)

    assertEquals(1.5d, divide(3, 2).get, 1e-9)
    assertEquals(None, divide(3, 0))

  //noinspection FilterHeadOption
  @Test def headOption(): Unit =
    val odds = List(1, 3, 5)
    val firstOdd = odds.headOption
    val firstEven = odds.filter(_ % 2 == 0).headOption

    assertTrue(firstOdd.isDefined)
    assertFalse(firstEven.isDefined)

  @Test def find(): Unit =
    val words = List("risible", "scavenger", "gist")
    val lowercase = words.find(w => w == w.toLowerCase())
    val uppercase = words.find(w => w == w.toUpperCase())

    assertTrue(lowercase.isDefined)
    assertFalse(uppercase.isDefined)

  @Test def map(): Unit =
    val option1: Option[String] = Some("word")
    val option2: Option[String] = None

    assertEquals(Some("WORD"), option1.map(_.toUpperCase()))
    assertEquals(None, option2.map(_.toUpperCase()))

  @Test def mapTwice(): Unit =
    // given
    class XX(var size: Option[Int]) {
    }
    val x1 = Some(new XX(Some(400)))
    val x2 = Some(new XX(None))
    val x3 = Option[XX](null)

    // when/then
    assertEquals(400, x1.map(_.size.getOrElse(0)).getOrElse(0))
    assertEquals(0, x2.map(_.size.getOrElse(0)).getOrElse(0))
    assertEquals(0, x3.map(_.size.getOrElse(0)).getOrElse(0))

  @Test def mapCollectionOfOptions(): Unit =
    val intOptions = Seq(None, Some(1), Some(2), None, Some(3), None, None)

    assertEquals(Seq(2, 4, 6), intOptions.map(intOp => intOp.map(int => int * 2)).filter(x => x.isDefined).map(x => x.get))
    assertEquals(Seq(2, 4, 6), intOptions.filter(intOp => intOp.isDefined).map(intOp => intOp.get).map(x => x * 2))
    assertEquals(Seq(2, 4, 6), intOptions.filter(_.isDefined).map(_.get).map(_ * 2))
    assertEquals(Seq(2, 4, 6), intOptions.filter(_.isDefined).map(_.get * 2))

