package com.redshiftsoft.example.scala.collections.monadic

import java.util.concurrent.atomic.LongAdder

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

  @Test def constructWithNull(): Unit = {
    val option = Option(null)
    Assert.assertTrue(option.isEmpty)
    Assert.assertFalse(option.isDefined)
  }

  @Test def constructSomeWithNull(): Unit = {
    val option = Some[String](null)
    Assert.assertTrue(option.isDefined)
    Assert.assertFalse(option.isEmpty)
  }

  @Test def none() : Unit = {
    val none: Option[String] = None
    Assert.assertTrue(none.isEmpty)
    Assert.assertFalse(none.isDefined)
  }

  @Test def getOrElse(): Unit = {
    val none: Option[String] = None
    Assert.assertEquals(100, none.getOrElse(100))
  }

  /* passing lazy value to getOrElse does NOT cause lazy to be evaluated */
  @Test def getOrElseWithLazyArg(): Unit = {
    val longAdder = new LongAdder
    def expensiveFunction(x : Int) : Int  = {
      println("EXPENSIVE")
      longAdder.add(100)
      42 * x
    }
    lazy val alternate = expensiveFunction(10)
    val option: Option[Int] = Some(50)
    Assert.assertEquals(50, option.getOrElse(alternate))
    Assert.assertEquals(0, longAdder.longValue())
  }

  @Test(expected = classOf[IllegalStateException])
  def getOrElseThrow(): Unit = {
    val none = None
    none.getOrElse(throw new IllegalStateException())
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

  @Test def optionalArithmeticResult(): Unit = {
    def divide(n: Double, d: Double): Option[Double] = {
      if (d == 0) None
      else Option(n / d)
    }

    Assert.assertEquals(1.5d, divide(3, 2).get, 1e-9)
    Assert.assertEquals(None, divide(3, 0))
  }

  //noinspection FilterHeadOption
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

  @Test def map(): Unit = {
    val option1: Option[String] = Some("word")
    val option2: Option[String] = None

    Assert.assertEquals(Some("WORD"), option1.map(_.toUpperCase()))
    Assert.assertEquals(None, option2.map(_.toUpperCase()))
  }

  @Test def mapTwice(): Unit = {
    // given
    class XX(var size: Option[Int]) {
    }
    val x1 = Some(new XX(Some(400)))
    val x2 = Some(new XX(None))
    val x3 = Option[XX](null)

    // when/then
    Assert.assertEquals(400, x1.map(_.size.getOrElse(0)).getOrElse(0))
    Assert.assertEquals(0, x2.map(_.size.getOrElse(0)).getOrElse(0))
    Assert.assertEquals(0, x3.map(_.size.getOrElse(0)).getOrElse(0))
  }

  @Test def mapCollectionOfOptions(): Unit = {
    val intOptions = Seq(None, Some(1), Some(2), None, Some(3), None, None)

    Assert.assertEquals(Seq(2, 4, 6), intOptions.map(intOp => intOp.map(int => int * 2)).filter(x => x.isDefined).map(x => x.get))
    Assert.assertEquals(Seq(2, 4, 6), intOptions.filter(intOp => intOp.isDefined).map(intOp => intOp.get).map(x => x * 2))
    Assert.assertEquals(Seq(2, 4, 6), intOptions.filter(_.isDefined).map(_.get).map(_ * 2))
    Assert.assertEquals(Seq(2, 4, 6), intOptions.filter(_.isDefined).map(_.get * 2))
  }

}
