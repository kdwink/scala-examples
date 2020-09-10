package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}


class Enumeration_UT {

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

}
