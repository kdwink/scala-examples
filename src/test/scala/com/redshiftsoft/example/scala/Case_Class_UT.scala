package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

/**
  * Case classes get automatically generated companion object with apply method and:
  *
  * copy, equals, hashCode, toString, unapply
  */
class Case_Class_UT {

  case class Character(name: String, isThief: Boolean, age: Int = 18)

  @Test
  def fields(): Unit = {
    val c = Character("Bill", isThief = false)
    Assert.assertEquals("Bill", c.name)
    Assert.assertEquals(false, c.isThief)
  }

  @Test
  def testEquals(): Unit = {
    val c1 = Character("George", isThief = true)
    val c2 = Character("George", isThief = true)
    // this works since we get an auto generated equals method that compares fields
    Assert.assertEquals(c1, c2)
  }

  @Test
  def copy(): Unit = {
    val c1 = Character("George", isThief = true)
    val c2 = c1.copy()
    Assert.assertEquals(c1, c2)
  }

  @Test
  def copyWithArg(): Unit = {
    val c1 = Character("George", isThief = true)
    val c2 = c1.copy(name = "Keith")
    Assert.assertEquals(Character("Keith", isThief = true), c2)
  }

  @Test
  def unapply(): Unit = {
    val c1 = Character("George", isThief = true, age = 25)
    val tuple = Character.unapply(c1).get
    Assert.assertEquals("George", tuple._1)
    Assert.assertEquals(true, tuple._2)
    Assert.assertEquals(25, tuple._3)
  }

  @Test
  def multipleConstructors(): Unit = {
    case class Foo(bar: Int, baz: Int) {
      def this(bar: Int) = this(bar, 100)

      def this(bar: Int, x: Int, y: Int) = this(bar, x + y)
    }

    val f1 = Foo(1, 2)
    val f2 = new Foo(1)
    val f3 = new Foo(1, 2, 3)


    Assert.assertEquals(2, f1.baz)
    Assert.assertEquals(100, f2.baz)
    Assert.assertEquals(5, f3.baz)
  }

  /* A case class can NOT extends another case class. */
  @Test
  def inheritance(): Unit = {
    case class Foo(a: String, b: String)
    class Bar(val c: String) extends Foo("aaa", "bbb")

    val bar = new Bar("ccc")

    Assert.assertEquals("aaa", bar.a)
    Assert.assertEquals("bbb", bar.b)
    Assert.assertEquals("ccc", bar.c)
  }

}