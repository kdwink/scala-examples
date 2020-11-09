package com.redshiftsoft.example.scala.collections.immutable

import java.util.NoSuchElementException

import org.junit.Assert._
import org.junit.Test

/**
  * Immutable linked list. Better to use Vector.
  */
class List_UT {

  @Test def declaring(): Unit = {
    val numbers1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val numbers2: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val colors1 = List("red", "blue", "green")
    val colors2: List[String] = List("red", "blue", "green")
  }

  @Test def declaring_listIsASeq(): Unit = {
    val seq: Seq[String] = List("aa", "bb", "cc")
  }

  @Test def accessing(): Unit = {
    val colors = List("red", "blue", "green")

    assertEquals("red", colors(0))
    assertEquals("blue", colors(1))
    assertEquals("red", colors.head)
  }

  @Test def iterating(): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    var sum = 0
    for (x <- numbers) sum += x
    assertEquals(45, sum)
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
    assertEquals("1,2,3,4,5,", output.toString())
  }

  @Test def sum(): Unit = {
    val numbers = List(1, 2, 3, 4)
    val result = numbers.sum
    assertEquals(10, result)
  }

  @Test def empty(): Unit = {
    val list1 = List()
    val list2 = List(1, 2, 3)
    assertTrue(list1.isEmpty)
    assertFalse(list2.isEmpty)
    assertEquals(Nil, list1)
  }

  @Test def empty_head(): Unit = {
    val list = List()
    try {
      list.head
      fail()
    } catch {
      case e: NoSuchElementException =>
    }
  }

  @Test def empty_tail(): Unit = {
    val list = List()
    try {
      list.tail
      fail()
    } catch {
      case e: UnsupportedOperationException =>
    }
  }

  @Test def splitAt(): Unit = {
    val list = List("aa", "bb", "cc", "dd", "ee", "ff", "gg")
    val listTuple = list.splitAt(4)
    assertEquals(4, listTuple._1.size)
    assertEquals(3, listTuple._2.size)
  }

  @Test def zip(): Unit = {
    val list1 = List("aa", "bb", "cc", "dd", "ee", "ff", "gg")
    val list2 = List("11", "22", "33", "44", "44", "66", "77")
    val tupleList = list1.zip(list2)
    assertEquals(7, tupleList.size)
    assertEquals("bb", tupleList(1)._1)
    assertEquals("22", tupleList(1)._2)
  }

  @Test def flatten(): Unit = {
    // given
    val list1 = List("aa", "bb")
    val list2 = List("11", "22")
    val list3 = List("--", "++")
    val list4 = List(list1, list2, list3)

    // when
    val flatList = list4.flatten

    // then
    assertEquals(6, flatList.size)
    assertEquals("aa,bb,11,22,--,++", flatList.mkString(","))
  }

  @Test def filter(): Unit = {
    val list1 = List("aa", "bb", "cc")
    val list2 = list1.filter(e => e.startsWith("bb"))

    assertEquals(1, list2.size)
    assertEquals("bb", list2.head)
  }

  @Test def filterNone(): Unit = {
    val list1 = List("aa", "bb", "cc")
    val list2 = list1.filter(e => e.startsWith("xxx"))

    assertEquals(0, list2.size)
  }

  @Test def sortBy(): Unit = {
    val list = List("a", "ccc", "bb", "ddddd", "eee", "fffffff", "gggg")
    val sortedList: List[String] = list.sortBy(x => x.length)
    assertEquals(List("a", "bb", "ccc", "eee", "gggg", "ddddd", "fffffff"), sortedList)
  }

  @Test def mkString(): Unit = {
    assertEquals("aa, bb, cc", List("aa", "bb", "cc").mkString(", "))
  }

  @Test def testToString(): Unit = {
    assertEquals("List(aa, bb, cc)", List("aa", "bb", "cc").toString)
  }

  @Test def testToBuffer(): Unit = {
    assertEquals("ArrayBuffer(aa, bb, cc)", List("aa", "bb", "cc").toBuffer.toString())
  }

  @Test def find(): Unit = {
    val list: List[String] = List("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm")
    var findCount = 0
    val maybeString: Option[String] = list.find(x => {
      findCount = findCount + 1
      x.startsWith("h")
    })
    assertEquals(8, findCount)
  }


  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // Symbolic operators.  Really these are just methods in List
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @Test def operator_cons(): Unit = {
    val numbers1 = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: 8 :: Nil
    val numbers2: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)

    assertEquals(numbers1, numbers2)
  }

  @Test def operator_appendList(): Unit = {
    val list1 = List("aa", "bb")
    val list2 = List("11", "22")
    val list3 = list1 ::: list2

    assertEquals(4, list3.size)
    assertEquals("aa", list3.head)
  }

  @Test def operator_appendElement(): Unit = {
    val list1 = List("aa", "bb")
    val list2 = list1 :+ "cc"

    assertEquals(2, list1.size)
    assertEquals(3, list2.size)
    assertEquals("aa", list2.head)
    assertEquals("bb", list2(1))
    assertEquals("cc", list2(2))
  }

  @Test def operator_prependElement(): Unit = {
    val list1 = List("aa", "bb")
    val list2 = "cc" :: list1

    assertEquals(2, list1.size)
    assertEquals(3, list2.size)
    assertEquals("cc", list2.head)
    assertEquals("aa", list2(1))
    assertEquals("bb", list2(2))
  }

  @Test def operator_appendSet(): Unit = {
    val list1 = List("aa", "bb")
    val set2 = Set("11", "22")
    val list3 = list1 ++ set2

    assertEquals(4, list3.size)
    assertEquals("aa", list3.head)
  }

  @Test def operator_equals(): Unit = {
    val list1 = List("aa", "bb")
    val list2 = List("11", "22")
    val list3 = List("aa", "bb")


    assertTrue(list1 == list1)
    assertTrue(list1 == list3)
    assertFalse(list1 == list2)
  }

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // stream operations
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @Test def map(): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = numbers.map(s => s * 2)
    assertEquals(List(2, 4, 6, 8, 10, 12, 14, 16, 18), result)
  }

  @Test def map_withPlaceholders(): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = numbers.map(_ * 2)
    assertEquals(List(2, 4, 6, 8, 10, 12, 14, 16, 18), result)
  }

  @Test def reduce(): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = numbers.reduce((a, b) => 1 + a + b)
    assertEquals(53, result)
  }

  @Test def reduce_withPlaceholders(): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = numbers.reduce(1 + _ + _)
    assertEquals(53, result)
  }

  /* Fold is similar to reduce, expect you can provided a starting value/accumulator, which lets you use a
   * different accumulator type than the list type if desired */
  @Test def fold(): Unit = {
    val numbers = List(1, 2, 3, 4)
    val result = numbers.fold(100) { (a, b) => a + b }
    assertEquals(110, result)
  }

  @Test def foldLeft(): Unit = {
    val numbers = List(1, 2, 3, 4)
    val result = numbers.foldLeft(100) { (a, b) => a + b }
    assertEquals(110, result)
  }

  @Test def foldRight(): Unit = {
    val numbers = List(1, 2, 3, 4)
    val result = numbers.foldRight(100) { (a, b) => a + b }
    assertEquals(110, result)
  }

  @Test def groupBy(): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val resultMap = numbers.groupBy(f => f % 2)

    assertEquals(2, resultMap.size)
    assertEquals("List(2, 4, 6, 8)", resultMap(0).toString)
    assertEquals("List(1, 3, 5, 7, 9)", resultMap(1).toString)
  }

  @Test def groupByObject(): Unit = {
    // given
    case class X(id: Int, name: String)
    val seq = Seq(
      X(10, "11"),
      X(20, "21"), X(20, "22"),
      X(30, "31"), X(30, "32"), X(30, "33")
    )
    // when
    val map = seq.groupBy(_.id)
    // then
    assertEquals(3, map.size)
    assertEquals(1, map(10).size)
    assertEquals(2, map(20).size)
    assertEquals(3, map(30).size)
  }

  @Test def group(): Unit = {
    val numbers = List(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5)
    val sizes = numbers.grouped(3).map(list => list.size).toList

    assertEquals("List(3, 3, 3, 3, 1)", sizes.toString)
  }

}
