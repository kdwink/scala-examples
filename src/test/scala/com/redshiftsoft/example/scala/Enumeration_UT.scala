package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}


class Enumeration_UT {

  object Breed extends Enumeration {
    type Breed = Value
    val doberman = Value("Doberman Pinscher")
    val yorkie = Value("Yorkshire Terrier")
    val scottie = Value("Scottish Terrier")
    val dane = Value("Great Dane")
    val portie = Value("Portuguese Water Dog")

    def isTerrier(b: Breed) = b.toString.endsWith("Terrier")

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
  def testIsTerrier: Unit = {
    Assert.assertTrue(Breed.isTerrier(Breed.yorkie))
    Assert.assertFalse(Breed.isTerrier(Breed.portie))
  }

}
