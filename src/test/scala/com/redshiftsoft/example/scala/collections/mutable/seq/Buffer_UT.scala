package com.redshiftsoft.example.scala.collections.mutable.seq

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import scala.collection.{immutable, mutable}

//noinspection AccessorLikeMethodIsUnit
class Buffer_UT:

  @Test def construct(): Unit =
    val nums1 = collection.mutable.Buffer(1, 2, 3)
    val nums2 = collection.mutable.ArrayBuffer(1, 2, 3)

    assertEquals(3, nums1.size)
    assertEquals(3, nums1.size)


  @Test def assign(): Unit =
    val seq1: mutable.Seq[Int] = mutable.ArrayBuffer(1, 2, 3, 4)
    val seq2: collection.Seq[Int] = mutable.ArrayBuffer(1, 2, 3, 4)

    assertEquals(4, seq1.size)
    assertEquals(4, seq2.size)

  @Test def toSeq_converts_from_mutable_to_immutable(): Unit =
    val buf1 = mutable.ArrayBuffer(1, 2, 3, 4)

    // This is expensive, iterates over all elements.
    val seq1: immutable.Seq[Int] = buf1.toSeq

    assertEquals("scala.collection.immutable.$colon$colon", buf1.toSeq.getClass.getName)

  @Test def append(): Unit =
    val nums = collection.mutable.Buffer(1, 2, 3)
    // when
    nums.append(100)
    // then
    assertEquals("ArrayBuffer(1, 2, 3, 100)", nums.toString)

  @Test def append_2(): Unit =
    val nums = collection.mutable.Buffer(1, 2, 3)
    // when
    for i <- 1 to 100 do nums += i
    // then
    assertEquals(103, nums.size)

  @Test def drop(): Unit =
    val buffer = collection.mutable.Buffer[String]("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh")
    // when
    val slice1: mutable.Buffer[String] = buffer.drop(3)
    // then
    assertEquals("ArrayBuffer(dd, ee, ff, gg, hh)", slice1.toString)
    assertEquals("ArrayBuffer(aa, bb, cc, dd, ee, ff, gg, hh)", buffer.toString)

  @Test def remove(): Unit =
    val buffer = collection.mutable.Buffer[String]("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh")
    // when
    buffer.remove(0, 3)
    // then
    assertEquals("ArrayBuffer(dd, ee, ff, gg, hh)", buffer.toString)
