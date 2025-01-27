package com.redshiftsoft.example.scala.collections.immutable.map

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertNotEquals, assertThrows, assertTrue}
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

  @Test def addEntry(): Unit = {
    // given
    var recentRequests = Map.empty[String, Long]
    val before = System.identityHashCode(recentRequests)

    // when
    recentRequests += "key" -> 24L

    // then
    val after = System.identityHashCode(recentRequests)
    assertNotEquals(before, after)
    assertEquals(1, recentRequests.size)
  }

  @Test def contains(): Unit =
    assertTrue(colorMap.contains("red"))
    assertFalse(colorMap.contains("yellow"))

  @Test def iterating(): Unit =
    var sum = 0
    for pair <- colorMap do sum = sum + pair._2

    assertEquals(16715775, sum)

  @Test def testToSeq(): Unit =
    // when
    val resultList: Seq[(String, Int)] = colorMap.toSeq
    // then
    assertEquals(3, resultList.size)
    assertTrue(resultList(1).isInstanceOf[(String, Int)])

  @Test def mapToTuples(): Unit =
    val tuplesIterator: Iterable[(String, Int)] = colorMap.keys.map(k => (k, colorMap(k)))
    var count = 0
    for x <- tuplesIterator do
      count = count + 1
    assertEquals(3, count)

  @Test def values(): Unit =
    val values = colorMap.values.toSeq
    assertEquals(Seq(0xFF0000, 0xF00, 0xFF), values)
