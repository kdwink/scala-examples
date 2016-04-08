package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

/**
  * Array is not a member of the Scala collections.  It is provided for JVM compatibility.
  *
  * Array is mutable.
  */
class Array_UT {

  val colors: Array[String] = Array("red", "green", "blue")

  @Test def declaring(): Unit = {
    var arrayChar: Array[Char] = new Array[Char](3)
    var arrayString: Array[String] = new Array[String](3)
  }

  @Test def accessing(): Unit = {
    colors(0) = "purple"
    colors(1) = "orange"

    Assert.assertEquals("purple", colors(0))
    Assert.assertEquals("orange", colors(1))
  }

  @Test def update(): Unit = {
    colors.update(0, "black")
    Assert.assertTrue(Array("black", "green", "blue") sameElements colors)
    Assert.assertFalse(Array("black", "green", "blue").equals(colors))
  }

  @Test def equality(): Unit = {
    Assert.assertTrue(Array("red", "green", "blue") sameElements colors)
    Assert.assertFalse(Array("red", "green", "blue").equals(colors))
  }

}