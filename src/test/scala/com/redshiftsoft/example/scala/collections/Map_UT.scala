package com.redshiftsoft.example.scala.collections

import org.junit.{Assert, Test}

class Map_UT {

  val colorMap = Map("red" -> 0xFF0000, "green" -> 0xF00, "blue" -> 0xFF)

  @Test def declaring(): Unit = {
    Assert.assertEquals(3, colorMap.size)
  }

  @Test def accessing(): Unit = {
    Assert.assertEquals(0xFF0000, colorMap("red"))
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
    val resultList: List[(String, Int)] = colorMap.toSeq.toList
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

}