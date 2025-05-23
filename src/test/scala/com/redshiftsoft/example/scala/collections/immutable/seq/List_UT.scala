package com.redshiftsoft.example.scala.collections.immutable.seq

import org.junit.*
import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

import scala.annotation.tailrec

/**
 * Immutable linked list. Better to use Vector.
 */
//noinspection ZeroIndexToHead,AccessorLikeMethodIsUnit
class List_UT:

  @Test def declaring(): Unit =
    val numbers1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val numbers2: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val colors1 = List("red", "blue", "green")
    val colors2: List[String] = List("red", "blue", "green")

  @Test def declaring_listIsASeq(): Unit =
    val seq: Seq[String] = List("aa", "bb", "cc")

  @Test def accessing(): Unit =
    val colors = List("red", "blue", "green")

    assertEquals("red", colors(0))
    assertEquals("blue", colors(1))
    assertEquals("red", colors.head)

  @Test def iterating(): Unit =
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    var sum = 0
    for x <- numbers do sum += x
    assertEquals(45, sum)

  @Test def iterating_manually(): Unit =

    @tailrec
    def visit(inList: List[Int], output: StringBuilder): Unit =
      if inList.nonEmpty then
        output.append(inList.head)
        output.append(",")
        visit(inList.tail, output)

    val inputList = List(1, 2, 3, 4, 5)
    val output = new StringBuilder()
    visit(inputList, output)
    assertEquals("1,2,3,4,5,", output.toString())

  @Test def empty(): Unit =
    val list1 = List()
    val list2 = List(1, 2, 3)
    assertTrue(list1.isEmpty)
    assertFalse(list2.isEmpty)
    assertEquals(Nil, list1)

  @Test def splitAt(): Unit =
    val list = List("aa", "bb", "cc", "dd", "ee", "ff", "gg")
    val listTuple = list.splitAt(4)
    assertEquals(4, listTuple._1.size)
    assertEquals(3, listTuple._2.size)

  @Test def filter(): Unit =
    val list1 = List("aa", "bb", "cc")
    val list2 = list1.filter(e => e.startsWith("bb"))

    assertEquals(1, list2.size)
    assertEquals("bb", list2.head)

  @Test def filterAll(): Unit =
    val list1 = List("aa", "bb", "cc")
    val list2 = list1.filter(e => e.startsWith("xxx"))

    assertEquals(0, list2.size)

  @Test def mkString(): Unit =
    assertEquals("aa, bb, cc", List("aa", "bb", "cc").mkString(", "))

  @Test def testToString(): Unit =
    assertEquals("List(aa, bb, cc)", List("aa", "bb", "cc").toString)

  @Test def toBuffer(): Unit =
    assertEquals("ArrayBuffer(aa, bb, cc)", List("aa", "bb", "cc").toBuffer.toString())

  @Test def find_stops_at_first_found(): Unit =
    val list: List[String] = List("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm")
    var findCount = 0
    val maybeString: Option[String] = list.find(x => {
      findCount = findCount + 1
      x.startsWith("h")
    })
    assertEquals(8, findCount)


  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // Symbolic operators.  Really these are just methods in List
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @Test def operator_cons(): Unit =
    val numbers1 = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: 8 :: Nil
    val numbers2: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)

    assertEquals(numbers1, numbers2)

  @Test def operator_appendList(): Unit =
    val list1 = List("aa", "bb", "cc")
    val list2 = List("11", "22", "33")
    val list3 = list1 ::: list2

    assertEquals(6, list3.size)
    assertEquals("aa", list3.head)
    assertEquals("33", list3.last)

  @Test def operator_appendElement(): Unit =
    val list1 = List("aa", "bb")
    val list2 = list1 :+ "cc"

    assertEquals(2, list1.size)
    assertEquals(3, list2.size)
    assertEquals(List("aa", "bb", "cc"), list2)

  @Test def operator_prependElement_1(): Unit =
    val list1 = List("aa", "bb")
    val list2 = "cc" +: list1

    assertEquals(2, list1.size)
    assertEquals(3, list2.size)
    assertEquals(List("cc", "aa", "bb"), list2)

  @Test def operator_prependElement_2(): Unit =
    val list1 = List("aa", "bb")
    val list2 = "cc" :: list1

    assertEquals(2, list1.size)
    assertEquals(3, list2.size)
    assertEquals(List("cc", "aa", "bb"), list2)

  @Test def operator_appendSet(): Unit =
    val list1 = List("aa", "bb")
    val set2 = Set("11", "22")
    val list3 = list1 ++ set2

    assertEquals(4, list3.size)
    assertEquals("aa", list3.head)

  @Test def operator_equals(): Unit =
    val list1 = List("aa", "bb")
    val list2 = List("11", "22")
    val list3 = List("aa", "bb")

    assertTrue(list1 == list1)
    assertTrue(list1 == list3)
    assertFalse(list1 == list2)

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // stream operations
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @Test def map(): Unit =
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = numbers.map(s => s * 2)
    assertEquals(List(2, 4, 6, 8, 10, 12, 14, 16, 18), result)

  @Test def map_withPlaceholders(): Unit =
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = numbers.map(_ * 2)
    assertEquals(List(2, 4, 6, 8, 10, 12, 14, 16, 18), result)

  /* Fold is similar to reduce, expect you can provide a starting value/accumulator, which lets you use a
   * different accumulator type than the list type if desired */
  @Test def fold(): Unit =
    val numbers: Seq[Int] = List(1, 2, 3, 4)
    val result: Int = numbers.fold(100) { (accumulator, item) => accumulator - item }
    // (((100 - 1) - 2) - 3) - 4 = 90
    assertEquals(90, result)

  // Same as fold
  @Test def foldLeft(): Unit =
    val numbers: Seq[Int] = List(1, 2, 3, 4)
    val result: Int = numbers.foldLeft(100) { (accumulator, item) => accumulator - item }
    // (((100 - 1) - 2) - 3) - 4 = 90
    assertEquals(90, result)

  @Test def foldRight(): Unit =
    val numbers : Seq[Int] = List(1, 2, 3, 4)
    val result: Int = numbers.foldRight(100) { (item, accumulator) => item - accumulator }
    // 1 - (2 - ((3 - (4 - 100)))) = 98
    assertEquals(98, result)

