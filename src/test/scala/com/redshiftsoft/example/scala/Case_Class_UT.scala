package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

/**
  * Case classes get automatically generated companion object with appply method and:
  *
  * copy, equals, hashCode, toString, unapply
  */
class Case_Class_UT {

  @Test
  def go(): Unit = {

    case class Character(name: String, isThief: Boolean)

    val c1 = Character("George", isThief = true)
    val c2 = Character("Bill", isThief = false)
    val c3 = new Character("George", isThief = true)
    val c4 = new Character("Bill", isThief = false)

    Assert.assertEquals("George", c1.name)
    Assert.assertEquals("Bill", c2.name)
    Assert.assertEquals("George", c3.name)
    Assert.assertEquals("Bill", c4.name)

    // this works since we get an auto generated equals method that compares fields
    Assert.assertEquals(c1, c3)
    Assert.assertEquals(c2, c4)
  }


}
