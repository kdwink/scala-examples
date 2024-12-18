package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertNull, assertTrue}
import org.junit.jupiter.api.Test

import java.nio.ByteBuffer
import scala.collection.immutable.ArraySeq
import scala.collection.{immutable, mutable}

/**
 * Array is not a member of the Scala collections.  It is provided for JVM compatibility.
 *
 * Array is mutable.
 */
//noinspection EqualityToSameElements,ComparingDiffCollectionKinds
class Array_UT:

  @Test def declaring(): Unit =
    var arrayChar: Array[Char] = new Array[Char](300)
    val arrayString: Array[String] = new Array[String](300)

    // The above arrays are declared with the specified SIZE (not just capacity)
    assertNull(arrayString(150))

  @Test def accessing(): Unit = 
    val colors: Array[String] = Array("red", "green", "blue", "white")
    colors(0) = "purple"
    colors(1) = "orange"

    assertEquals("purple", colors(0))
    assertEquals("orange", colors(1))

  @Test def update(): Unit = 
    val colors: Array[String] = Array("red", "green", "blue", "white")
    colors.update(0, "black")
    assertTrue(Array("black", "green", "blue", "white") sameElements colors)
    assertFalse(Array("black", "green", "blue", "white").equals(colors))

  @Test def equality(): Unit = 
    val a1 = Array("red", "green", "blue", "white")
    val a2 = Array("red", "green", "blue", "white")

    assertTrue(a1 sameElements a2)

    assertFalse(a1 == a2)
    assertFalse(a1.eq(a2))
    assertFalse(a1.equals(a2))

  @Test def slice(): Unit = 
    val colors: Array[String] = Array("red", "green", "blue", "white")
    assertTrue(Array("green", "blue") sameElements colors.slice(1, 3))

  @Test def slice_IsAlwaysCopy(): Unit = 
    // given
    val colors: Array[String] = Array("red", "green", "blue", "white")

    // when
    val allSlice: mutable.ArraySeq[String] = colors.slice(0, 4)

    // then
    assertTrue(colors sameElements allSlice)
    assertFalse(colors.equals(allSlice))

  @Test def lastOption(): Unit = 
    val array = Array[Long](1, 2, 3, 4, 5, 4, 3, 2, 1)
    assertEquals(5L, array.sorted.lastOption.getOrElse(0))

  @Test def readingByteArrayWithBuffer(): Unit = 
    val byteArray = Array[Byte](50, 41, 32, 23, 64, 75, 86, 97, 108)
    val buffer = ByteBuffer.wrap(byteArray)
    val float1: Float = buffer.getFloat(0)
    val float2: Float = buffer.getFloat(4)
    assertEquals(9.844391080093828E-9f, float1, 1e-9)
    assertEquals(3.177147150039673f, float2, 1e-9)

  @Test def className(): Unit = 
    val array = Array[String]("aa", "bb", "cc")
    assertEquals("[Ljava.lang.String;", array.getClass.getName)

  @Test def assigningToSeq(): Unit = 
    val array = Array[String]("aa", "bb", "cc")
    assertEquals("[Ljava.lang.String;", array.getClass.getName)

    // In scala 2.12 is this is possible because of an expensive implicit conversion.
    val seq1: immutable.Seq[String] = ArraySeq.unsafeWrapArray(array)
    assertEquals("scala.collection.immutable.ArraySeq$ofRef", seq1.getClass.getName)

    // This is still possible and efficient.
    val seq2: scala.collection.Seq[String] = array
    assertEquals("scala.collection.mutable.ArraySeq$ofRef", seq2.getClass.getName)

