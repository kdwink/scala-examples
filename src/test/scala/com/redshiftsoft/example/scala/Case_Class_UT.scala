package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


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
    assertEquals("Bill", c.name)
    assertEquals(false, c.isThief)
  }

  @Test
  def testEquals(): Unit = {
    val c1 = Character("George", isThief = true)
    val c2 = Character("George", isThief = true)
    // this works since we get an auto generated equals method that compares fields
    assertEquals(c1, c2)
  }

  @Test
  def copy(): Unit = {
    val c1 = Character("George", isThief = true)
    val c2 = c1.copy()
    assertEquals(c1, c2)
  }

  @Test
  def copyWithArg(): Unit = {
    val c1 = Character("George", isThief = true)
    val c2 = c1.copy(name = "Keith")
    assertEquals(Character("Keith", isThief = true), c2)
  }

  @Test
  def unapply(): Unit = {
    val c1 = Character("George", isThief = true, age = 25)
    val tuple = Character.unapply(c1)
    assertEquals("George", tuple._1)
    assertEquals(true, tuple._2)
    assertEquals(25, tuple._3)
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


    assertEquals(2, f1.baz)
    assertEquals(100, f2.baz)
    assertEquals(5, f3.baz)
  }

  /* A case class can NOT extend another case class. */
  @Test
  def inheritance_case_class_extended(): Unit = {
    case class Foo(a: String, b: String)
    class Bar(val c: String) extends Foo("aaa", "bbb")

    val bar = new Bar("ccc")

    assertEquals("aaa", bar.a)
    assertEquals("bbb", bar.b)
    assertEquals("ccc", bar.c)
  }

  /* A case class can NOT extend another case class. */
  @Test
  def inheritance_case_class_extends(): Unit = {
    class Bar(val c: String)
    case class Foo(a: String, b: String) extends Bar("bla")

    val foo = Foo("ccc", "ddd")

    assertEquals("ccc", foo.a)
    assertEquals("ddd", foo.b)
    assertEquals("bla", foo.c)
  }

}
