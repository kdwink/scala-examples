package com.redshiftsoft.example.scala.collections.immutable

import org.junit.{Assert, Test}

class Map_UT {

  val colorMap = Map("red" -> 0xFF0000, "green" -> 0xF00, "blue" -> 0xFF)

  @Test def declaring(): Unit = {
    Assert.assertEquals(3, colorMap.size)
  }

  @Test def accessing(): Unit = {
    Assert.assertEquals(0xFF0000, colorMap("red"))
  }

  @Test(expected = classOf[java.util.NoSuchElementException])
  def accessing_NonExistingKey(): Unit = {
    Assert.assertEquals(0xFF0000, colorMap("frank"))
  }

  @Test def accessing_WithGet(): Unit = {
    Assert.assertEquals(0xFF0000, colorMap.get("red").get)
  }

  @Test(expected = classOf[java.util.NoSuchElementException])
  def accessing_WithGet_NonExistingKey(): Unit = {
    val maybeInt: Option[Int] = colorMap.get("frank")
    Assert.assertEquals(0xFF0000, maybeInt.get)
  }

  @Test def contains(): Unit = {
    Assert.assertTrue(colorMap.contains("red"))
    Assert.assertFalse(colorMap.contains("yellow"))
  }

  @Test def iterating(): Unit = {
    var sum = 0
    for (pair <- colorMap) {
      sum = sum + pair._2
    }

    Assert.assertEquals(16715775, sum)
  }

  @Test def testToSeq(): Unit = {
    val resultList: Seq[(String, Int)] = colorMap.toSeq
    Assert.assertEquals(3, resultList.size)
    Assert.assertTrue(resultList(1).isInstanceOf[Tuple2[String, Int]])
  }

  @Test def mapToTuples(): Unit = {
    val tuplesIterator: Iterable[(String, Int)] = colorMap.keys.map(k => (k, colorMap(k)))
    var count = 0
    for (x <- tuplesIterator) {
      count = count + 1
    }
    Assert.assertEquals(3, count)
  }

  @Test def values(): Unit = {
    val values = colorMap.values.toSeq
    Assert.assertEquals(Seq(0xFF0000, 0xF00, 0xFF), values)
  }


}
