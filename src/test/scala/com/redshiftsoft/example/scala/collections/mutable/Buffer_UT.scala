package com.redshiftsoft.example.scala.collections.mutable


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import scala.collection.mutable

class Buffer_UT {

  @Test def construct(): Unit = {
    val nums1 = collection.mutable.Buffer(1, 2, 3)
    val nums2 = collection.mutable.ArrayBuffer(1, 2, 3)

    assertEquals(3, nums1.size)
    assertEquals(3, nums1.size)

    for (i <- 1 to 100) nums1 += i
    for (i <- 1 to 100) nums2 += i
    assertEquals(103, nums1.size)
    assertEquals(103, nums2.size)
  }

  @Test def assign(): Unit = {
    val seq1: mutable.Seq[Int] = mutable.ArrayBuffer(1, 2, 3, 4)
    val seq2: collection.Seq[Int] = mutable.ArrayBuffer(1, 2, 3, 4)

    assertEquals(4, seq1.size)
    assertEquals(4, seq2.size)
  }

  @Test def returnTypeOfToSeq(): Unit = {
    val buf1 = mutable.ArrayBuffer(1, 2, 3, 4)

    // This is expensive, iterates over all elements.
    val seq1: Seq[Int] = buf1.toSeq

    assertEquals("scala.collection.immutable.$colon$colon", buf1.toSeq.getClass.getName)
  }

  @Test def slice(): Unit = {
    val nums = collection.mutable.Buffer(1, 2, 3, 4, 5, 6, 7, 8, 9)
    // when
    val slice1: mutable.Buffer[Int] = nums.slice(4, 7)
    // then
    assertEquals("ArrayBuffer(5, 6, 7)", slice1.toString)
  }

  @Test def append(): Unit = {
    val nums = collection.mutable.Buffer(1, 2, 3)
    // when
    nums.append(100)
    // then
    assertEquals("ArrayBuffer(1, 2, 3, 100)", nums.toString)
  }

  @Test def take(): Unit = {
    // given
    val buffer = collection.mutable.Buffer[String]("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh")
    // when
    val slice1: mutable.Buffer[String] = buffer.take(3)
    // then
    assertEquals("ArrayBuffer(aa, bb, cc)", slice1.toString)
    assertEquals("ArrayBuffer(aa, bb, cc, dd, ee, ff, gg, hh)", buffer.toString)
  }

  @Test def drop(): Unit = {
    val buffer = collection.mutable.Buffer[String]("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh")
    // when
    val slice1: mutable.Buffer[String] = buffer.drop(3)
    // then
    assertEquals("ArrayBuffer(dd, ee, ff, gg, hh)", slice1.toString)
    assertEquals("ArrayBuffer(aa, bb, cc, dd, ee, ff, gg, hh)", buffer.toString)
  }

  @Test def remove(): Unit = {
    val buffer = collection.mutable.Buffer[String]("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh")
    // when
    buffer.remove(0, 3)
    // then
    assertEquals("ArrayBuffer(dd, ee, ff, gg, hh)", buffer.toString)
  }


}
