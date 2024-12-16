package com.redshiftsoft.example.scala.collections.immutable

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertThrows, assertTrue}
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class Map_UT:

  private val colorMap = Map("red" -> 0xFF0000, "green" -> 0xF00, "blue" -> 0xFF)

  @Test def declaring(): Unit =
    assertEquals(3, colorMap.size)

  @Test def accessing(): Unit =
    assertEquals(0xFF0000, colorMap("red"))

  @Test
  def accessing_NonExistingKey(): Unit =
    assertThrows(classOf[java.util.NoSuchElementException], () => colorMap("frank"))

  //noinspection MapGetGet
  @Test def accessing_WithGet(): Unit =
    assertEquals(0xFF0000, colorMap.get("red").get)

  @Test
  def accessing_WithGet_NonExistingKey(): Unit =
    assertThrows(classOf[java.util.NoSuchElementException], () => {
      val maybeInt: Option[Int] = colorMap.get("frank")
      assertEquals(0xFF0000, maybeInt.get)
    })

  @Test def contains(): Unit =
    assertTrue(colorMap.contains("red"))
    assertFalse(colorMap.contains("yellow"))

  @Test def iterating(): Unit =
    var sum = 0
    for (pair <- colorMap) {
      sum = sum + pair._2
    }

    assertEquals(16715775, sum)

  @Test def testToSeq(): Unit =
    val resultList: Seq[(String, Int)] = colorMap.toSeq
    assertEquals(3, resultList.size)
    assertTrue(resultList(1).isInstanceOf[Tuple2[String, Int]])

  @Test def mapToTuples(): Unit =
    val tuplesIterator: Iterable[(String, Int)] = colorMap.keys.map(k => (k, colorMap(k)))
    var count = 0
    for (x <- tuplesIterator) {
      count = count + 1
    }
    assertEquals(3, count)

  @Test def values(): Unit =
    val values = colorMap.values.toSeq
    assertEquals(Seq(0xFF0000, 0xF00, 0xFF), values)
