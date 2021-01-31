package com.redshiftsoft.example.scala

import java.nio.ByteBuffer

import org.junit.{Assert, Test}

import scala.collection.mutable

/**
 * Array is not a member of the Scala collections.  It is provided for JVM compatibility.
 *
 * Array is mutable.
 */
class Array_UT {

  val colors: Array[String] = Array("red", "green", "blue", "white")

  @Test def declaring(): Unit = {
    var arrayChar: Array[Char] = new Array[Char](300)
    var arrayString: Array[String] = new Array[String](300)

    // The above arrays are declared with the specified SIZE (not just capacity)
    Assert.assertNull(arrayString(150))
  }

  @Test def accessing(): Unit = {
    colors(0) = "purple"
    colors(1) = "orange"

    Assert.assertEquals("purple", colors(0))
    Assert.assertEquals("orange", colors(1))
  }

  @Test def update(): Unit = {
    colors.update(0, "black")
    Assert.assertTrue(Array("black", "green", "blue", "white") sameElements colors)
    Assert.assertFalse(Array("black", "green", "blue", "white").equals(colors))
  }

  @Test def equality(): Unit = {
    Assert.assertTrue(Array("red", "green", "blue", "white") sameElements colors)
    Assert.assertFalse(Array("red", "green", "blue", "white").equals(colors))
  }

  @Test def slice(): Unit = {
    Assert.assertTrue(Array("green", "blue") sameElements colors.slice(1, 3))
  }

  @Test def slice_IsAlwaysCopy(): Unit = {
    val allSlice: mutable.WrappedArray[String] = colors.slice(0, 4)
    Assert.assertTrue(colors sameElements allSlice)
    Assert.assertFalse(colors.equals(allSlice))
  }

  @Test def readingByteArrayWithBuffer(): Unit = {
    val byteArray = Array[Byte](50, 41, 32, 23, 64, 75, 86, 97, 108)
    val buffer = ByteBuffer.wrap(byteArray)
    val float1: Float = buffer.getFloat(0)
    val float2: Float = buffer.getFloat(4)
    Assert.assertEquals(9.844391080093828E-9f, float1, 1e-9)
    Assert.assertEquals(3.177147150039673f, float2, 1e-9)
  }

  @Test def className(): Unit = {
    val array = Array[String]("aa", "bb", "cc")
    Assert.assertEquals("[Ljava.lang.String;", array.getClass.getName)
  }

  @Test def assigningToSeq(): Unit = {
    val array = Array[String]("aa", "bb", "cc")
    Assert.assertEquals("[Ljava.lang.String;", array.getClass.getName)

    // In scala 2.12 is this is possible because of an expensive implicit conversion.
    val seq: Seq[String] = array

    Assert.assertEquals("scala.collection.mutable.WrappedArray$ofRef", seq.getClass.getName)
  }

}