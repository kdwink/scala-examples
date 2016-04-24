package com.redshiftsoft.example.scala.collections

import java.util.NoSuchElementException

import org.junit.{Assert, Test}

class List_UT {

  @Test def declaring(): Unit = {
    val numbers1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val numbers2: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val colors1 = List("red", "blue", "green")
    val colors2: List[String] = List("red", "blue", "green")
  }

  @Test def accessing(): Unit = {
    val colors = List("red", "blue", "green")

    Assert.assertEquals("red", colors(0))
    Assert.assertEquals("blue", colors(1))
    Assert.assertEquals("red", colors.head)
  }

  @Test def iterating(): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    var sum = 0
    for (x <- numbers) sum += x
    Assert.assertEquals(45, sum)
  }

  @Test def iterating_manually(): Unit = {

    def visit(inList: List[Int], output: StringBuilder): Unit = {
      if (inList.nonEmpty) {
        output.append(inList.head)
        output.append(",")
        visit(inList.tail, output)
      }
    }

    val inputList = List(1, 2, 3, 4, 5)
    val output = StringBuilder.newBuilder
    visit(inputList, output)
    Assert.assertEquals("1,2,3,4,5,", output.toString())
  }

  @Test def map(): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = numbers.map(s => s * 2)
    Assert.assertEquals(List(2, 4, 6, 8, 10, 12, 14, 16, 18), result)
  }

  @Test def map_withPlaceholders(): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = numbers.map(_ * 2)
    Assert.assertEquals(List(2, 4, 6, 8, 10, 12, 14, 16, 18), result)
  }

  @Test def reduce(): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = numbers.reduce((a, b) => 1 + a + b)
    Assert.assertEquals(53, result)
  }

  @Test def reduce_withPlaceholders(): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = numbers.reduce(1 + _ + _)
    Assert.assertEquals(53, result)
  }

  /* Fold is similar to reduce, expect you can provided a starting value */
  @Test def fold(): Unit = {
    val numbers = List(1, 2, 3, 4)
    val result = numbers.fold(100) { (a, b) => a + b }
    Assert.assertEquals(110, result)
  }

  @Test def sum(): Unit = {
    val numbers = List(1, 2, 3, 4)
    val result = numbers.sum
    Assert.assertEquals(10, result)
  }

  @Test def empty(): Unit = {
    val list1 = List()
    val list2 = List(1, 2, 3)
    Assert.assertTrue(list1.isEmpty)
    Assert.assertFalse(list2.isEmpty)
    Assert.assertEquals(Nil, list1)
  }

  @Test def empty_head(): Unit = {
    val list = List()
    try {
      list.head
      Assert.fail()
    } catch {
      case e: NoSuchElementException =>
    }
  }

  @Test def empty_tail(): Unit = {
    val list = List()
    try {
      list.tail
      Assert.fail()
    } catch {
      case e: UnsupportedOperationException =>
    }
  }

  @Test def splitAt(): Unit = {
    val list = List("aa", "bb", "cc", "dd", "ee", "ff", "gg")
    val listTuple = list.splitAt(4)
    Assert.assertEquals(4, listTuple._1.size)
    Assert.assertEquals(3, listTuple._2.size)
  }

  @Test def zip(): Unit = {
    val list1 = List("aa", "bb", "cc", "dd", "ee", "ff", "gg")
    val list2 = List("11", "22", "33", "44", "44", "66", "77")
    val tupleList = list1.zip(list2)
    Assert.assertEquals(7, tupleList.size)
    Assert.assertEquals("bb", tupleList(1)._1)
    Assert.assertEquals("22", tupleList(1)._2)
  }

  @Test def flatten(): Unit = {
    val list1 = List("aa", "bb")
    val list2 = List("11", "22")
    val list3 = List("--", "++")
    val list4 = List(list1, list2, list3)
    val list5 = list4.flatten

    Assert.assertEquals(6, list5.size)
    Assert.assertEquals("aa", list5(0))
    Assert.assertEquals("++", list5(5))
  }

  @Test def sortBy(): Unit = {
    val list = List("a", "ccc", "bb", "ddddd", "eee", "fffffff", "gggg")
    val sortedList: List[String] = list.sortBy(x => x.length)
    Assert.assertEquals(List("a", "bb", "ccc", "eee", "gggg", "ddddd", "fffffff"), sortedList)
  }

  @Test def mkString(): Unit = {
    Assert.assertEquals("aa, bb, cc", List("aa", "bb", "cc").mkString(", "))
  }

  @Test def testToString(): Unit = {
    Assert.assertEquals("List(aa, bb, cc)", List("aa", "bb", "cc").toString)
  }

  @Test def testToBuffer(): Unit = {
    Assert.assertEquals("ArrayBuffer(aa, bb, cc)", List("aa", "bb", "cc").toBuffer.toString())
  }

  @Test def find(): Unit = {
    val list: List[String] = List("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm")
    var findCount = 0
    val maybeString: Option[String] = list.find(x => {
      findCount = findCount + 1
      x.startsWith("h")
    })
    Assert.assertEquals(8, findCount)
  }


  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // Symbolic operators.  Really these are just methods in List
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @Test def operator_cons(): Unit = {
    val numbers1 = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: 8 :: Nil
    val numbers2: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)

    Assert.assertEquals(numbers1, numbers2)
  }

  @Test def operator_appendList(): Unit = {
    val list1 = List("aa", "bb")
    val list2 = List("11", "22")
    val list3 = list1 ::: list2

    Assert.assertEquals(4, list3.size)
    Assert.assertEquals("aa", list3.head)
  }

  @Test def operator_appendElement(): Unit = {
    val list1 = List("aa", "bb")
    val list2 = list1 :+ "cc"

    Assert.assertEquals(3, list2.size)
    Assert.assertEquals("aa", list2.head)
    Assert.assertEquals("bb", list2(1))
    Assert.assertEquals("cc", list2(2))
  }

  @Test def operator_appendSet(): Unit = {
    val list1 = List("aa", "bb")
    val set2 = Set("11", "22")
    val list3 = list1 ++ set2

    Assert.assertEquals(4, list3.size)
    Assert.assertEquals("aa", list3.head)
  }

  @Test def operator_equals(): Unit = {
    val list1 = List("aa", "bb")
    val list2 = List("11", "22")
    val list3 = List("aa", "bb")


    Assert.assertTrue(list1 == list1)
    Assert.assertTrue(list1 == list3)
    Assert.assertFalse(list1 == list2)
  }


}
