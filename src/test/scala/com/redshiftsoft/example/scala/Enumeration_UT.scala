package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test


class Enumeration_UT {


  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // simple example
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  object Breed extends Enumeration {
    type Breed = Value
    val doberman: Breed = Value("Doberman Pinscher")
    val yorkie: Breed = Value("Yorkshire Terrier")
    val scottie: Breed = Value("Scottish Terrier")
    val dane: Breed = Value("Great Dane")
    val portie: Breed = Value("Portuguese Water Dog")

    def isTerrier(b: Breed): Boolean = b.toString.endsWith("Terrier")

  }

  @Test
  def test(): Unit = {
    var count = 0
    for (breed <- Breed.values) {
      count = count + 1
    }
    assertEquals(5, count)
  }

  @Test
  def testToString(): Unit = {
    assertEquals("Great Dane", Breed.dane.toString)
    assertEquals(Breed.dane, Breed.withName("Great Dane"))
  }

  @Test
  def testIsTerrier(): Unit = {
    assertTrue(Breed.isTerrier(Breed.yorkie))
    assertFalse(Breed.isTerrier(Breed.portie))
  }

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // more involved example
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  object Color extends Enumeration {

    type Color = ColorVal

    val RED: ColorVal = ColorVal("Blue", 1000)
    val BLUE: ColorVal = ColorVal("Blue", 2000)
    val GREEN: ColorVal = ColorVal("Blue", 3000)

    case class ColorVal(name: String, colorId: Int) extends super.Val {

      def isBlue: Boolean = BLUE == this

      def isRed: Boolean = RED == this

    }

  }

  @Test
  def withName(): Unit = {
    val color = Color.withName("GREEN")
    assertEquals(Color.GREEN, color)
  }

  @Test
  def testCustomMethod(): Unit = {
    assertTrue(Color.BLUE.isBlue)
    assertFalse(Color.GREEN.isBlue)
    assertFalse(Color.RED.isBlue)
  }

  @Test
  def testCustomMethodAgain(): Unit = {
    val x: Color.Color = Color.RED
    assertTrue(x.isRed)
  }

  @Test
  def testColorToString(): Unit = {

    assertEquals("BLUE,GREEN,RED", Color.values.map(_.toString).mkString(","))

  }


}
