package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

/**
  * Case classes get automatically generated companion object with appply method and:
  *
  * copy, equals, hashCode, toString, unapply
  */
class Case_Class_UT {

  case class Character(name: String, isThief: Boolean)

  @Test
  def fields(): Unit = {
    val c = Character("Bill", isThief = false)
    Assert.assertEquals("Bill", c.name)
    Assert.assertEquals(false, c.isThief)
  }

  @Test
  def testEquals(): Unit = {
    val c1 = Character("George", isThief = true)
    val c2 = new Character("George", isThief = true)
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
  def unapply(): Unit = {
    val c1 = Character("George", isThief = true)
    val tupple = Character.unapply(c1).get
    Assert.assertEquals("George", tupple._1)
    Assert.assertEquals(true, tupple._2)
  }

}