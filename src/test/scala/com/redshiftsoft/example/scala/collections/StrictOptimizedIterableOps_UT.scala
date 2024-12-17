package com.redshiftsoft.example.scala.collections

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StrictOptimizedIterableOps_UT:

  @Test def zip(): Unit =
    val list1 = List("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh")
    val list2 = List("11", "22", "33", "44", "44", "66", "77", "88")

    // when
    val tupleList: List[(String, String)] = list1.zip(list2)

    // then
    assertEquals(8, tupleList.size)
    val secondTuple = tupleList(1)
    assertEquals("bb", secondTuple._1)
    assertEquals("22", secondTuple._2)


  @Test def flatten(): Unit =
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

