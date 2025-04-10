package com.redshiftsoft.example.scala.collections

import org.junit.Assert.{assertEquals, assertFalse, assertTrue}
import org.junit.{Assert, Test}

class Map_UT {

  private val colorMap: Map[String, Int] = Map("red" -> 0xFF0000, "green" -> 0xF00, "blue" -> 0xFF)

  @Test def declaring(): Unit = {
    assertEquals(3, colorMap.size)
  }

  @Test def accessing(): Unit = {
    assertEquals(0xFF0000, colorMap("red"))
  }

  @Test(expected = classOf[java.util.NoSuchElementException])
  def accessing_NonExistingKey(): Unit = {
    assertEquals(0xFF0000, colorMap("frank"))
  }

  @Test def accessing_WithGet(): Unit = {
    assertEquals(0xFF0000, colorMap.get("red").get)
  }

  @Test(expected = classOf[java.util.NoSuchElementException])
  def accessing_WithGet_NonExistingKey(): Unit = {
    val maybeInt: Option[Int] = colorMap.get("frank")
    assertEquals(0xFF0000, maybeInt.get)
  }

  @Test def contains(): Unit = {
    assertTrue(colorMap.contains("red"))
    assertFalse(colorMap.contains("yellow"))
  }

  @Test def iterating(): Unit = {
    var sum = 0
    for (pair <- colorMap) {
      sum = sum + pair._2
    }

    assertEquals(16715775, sum)
  }

  @Test def testToSeq(): Unit = {
    val resultList: Seq[(String, Int)] = colorMap.toSeq
    assertEquals(3, resultList.size)
    assertTrue(resultList(1).isInstanceOf[Tuple2[String, Int]])
  }

  @Test def mapToTuples(): Unit = {
    val tuplesIterator: Iterable[(String, Int)] = colorMap.keys.map(k => (k, colorMap(k)))
    var count = 0
    for (x <- tuplesIterator) {
      count = count + 1
    }
    assertEquals(3, count)
  }

  @Test def values(): Unit = {
    val values = colorMap.values.toSeq
    assertEquals(Seq(0xFF0000, 0xF00, 0xFF), values)
  }


}