package com.redshiftsoft.example.scala

import org.junit.Assert.assertEquals
import org.junit.{Assert, Test}


class Enumeration_UT {


  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  //
  // simple example
  //
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

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
    Assert.assertEquals(5, count)
  }

  @Test
  def testToString(): Unit = {
    Assert.assertEquals("Great Dane", Breed.dane.toString)
  }

  @Test
  def testIsTerrier(): Unit = {
    Assert.assertTrue(Breed.isTerrier(Breed.yorkie))
    Assert.assertFalse(Breed.isTerrier(Breed.portie))
  }

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  //
  // more involved example
  //
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  object Color extends Enumeration {

    type Color = ColorVal

    val RED: ColorVal = ColorVal("Blue", 1000)
    val BLUE: ColorVal = ColorVal("Blue", 2000)
    val GREEN: ColorVal = ColorVal("Blue", 3000)

    case class ColorVal(name: String, colorId: Int) extends super.Val {

      def isBlue: Boolean = BLUE == this

      def isRed: Boolean = RED == this

    }

    //def withName(s: String): Option[Value] = values.find(_.toString == s)

  }

  @Test
  def withName_should_work_if_case_matches(): Unit = {
    val red = Color.withName("RED")
    assertEquals(Color.RED, red)
  }

  @Test
  def withName_should_return_none_if_case_matches(): Unit = {
    Assert.assertThrows(classOf[NoSuchElementException], () => Color.withName("red"))
  }

  @Test
  def testCustomMethod(): Unit = {
    Assert.assertTrue(Color.BLUE.isBlue)
    Assert.assertFalse(Color.GREEN.isBlue)
    Assert.assertFalse(Color.RED.isBlue)
  }

  @Test
  def testCustomMethodAgain(): Unit = {
    val x: Color.Color = Color.RED
    Assert.assertTrue(x.isRed)
  }

  @Test
  def testColorToString(): Unit = {

    Assert.assertEquals("BLUE,GREEN,RED", Color.values.map(_.toString).mkString(","))

  }


}
