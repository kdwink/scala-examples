package com.redshiftsoft.example.scala.collections.monadic

import org.junit.{Assert, Test}

class Option_UT {

  @Test def get(): Unit = {
    val none: Option[String] = None
    try {
      none.get
      Assert.fail()
    } catch {
      case e: NoSuchElementException =>
    }
  }

  @Test def getOrElse(): Unit = {
    val none: Option[String] = None
    Assert.assertEquals(100, none.getOrElse(100))
  }

  @Test def option(): Unit = {
    var x: String = "stuff"
    val option = Option(x)
    Assert.assertFalse(option.isEmpty)
    Assert.assertTrue(option.isDefined)

    /* Changing x doesn't change the options */
    x = null
    Assert.assertFalse(option.isEmpty)
    Assert.assertTrue(option.isDefined)
  }

  @Test def example(): Unit = {
    def divide(n: Double, d: Double): Option[Double] = {
      if (d == 0) None
      else Option(n / d)
    }

    Assert.assertEquals(1.5d, divide(3, 2).get, 1e-9)
    Assert.assertEquals(None, divide(3, 0))
  }

  @Test def headOption(): Unit = {
    val odds = List(1, 3, 5)
    val firstOdd = odds.headOption
    val firstEven = odds.filter(_ % 2 == 0).headOption

    Assert.assertTrue(firstOdd.isDefined)
    Assert.assertFalse(firstEven.isDefined)
  }

  @Test def find(): Unit = {
    val words = List("risible", "scavenger", "gist")
    val lowercase = words.find(w => w == w.toLowerCase())
    val uppercase = words.find(w => w == w.toUpperCase())

    Assert.assertTrue(lowercase.isDefined)
    Assert.assertFalse(uppercase.isDefined)
  }

  @Test def findOperatingOnOptional(): Unit = {
    val words = List("risible", "scavenger", "gist")
    val upperCaseSizes = words.find(w => w == w.toUpperCase()).map(_.size)

    Assert.assertFalse(upperCaseSizes.isDefined)
    Assert.assertEquals(None, upperCaseSizes)
  }


}