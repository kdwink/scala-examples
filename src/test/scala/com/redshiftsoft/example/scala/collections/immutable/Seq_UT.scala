package com.redshiftsoft.example.scala.collections.immutable

import org.junit.Assert.{assertEquals, assertFalse, assertTrue}
import org.junit.Test

class Seq_UT {

  @Test def constructor(): Unit = {
    // given
    val x1 = Seq("one", "two", "three")
    val x2 = scala.collection.Seq("one", "two", "three")
    val x3 = scala.collection.immutable.Seq("one", "two", "three")
    val x4 = scala.collection.mutable.Seq("one", "two", "three")

    // then
    assertEquals(3, x1.size)
    assertEquals("scala.collection.immutable.$colon$colon", x1.getClass.getName)
    assertEquals("scala.collection.immutable.$colon$colon", x2.getClass.getName)
    assertEquals("scala.collection.immutable.$colon$colon", x3.getClass.getName)
    assertEquals("scala.collection.mutable.ArrayBuffer", x4.getClass.getName)
  }

  @Test def flatten(): Unit = {
    // given
    val seq1 = Seq("aa", "bb")
    val seq2 = Seq("11", "22")
    val seq3 = Seq("--", "++")
    val seq4 = Seq(seq1, seq2, seq3)

    // when
    val flatSeq = seq4.flatten

    // then
    assertEquals(6, flatSeq.size)
    assertEquals("aa,bb,11,22,--,++", flatSeq.mkString(","))
  }

  @Test def diff(): Unit = {
    val seq1 = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10)
    val seq2 = Seq(4, 5, 6, 10, 10)

    val diff = seq1.diff(seq2)

    assertEquals("1,2,3,7,8,9,10,10,10", diff.mkString(","))
  }

  //noinspection ComparingUnrelatedTypes,ComparingDiffCollectionKinds,EqualityToSameElements
  @Test def equals(): Unit = {
    val seq1 = Seq(1, 2, 2, 3, 3, 3)
    val seq2 = Array(1, 2, 2, 3, 3, 3)

    assertFalse("not identity equal", seq1.eq(seq2))
    assertFalse("sequences are not equal to arrays", seq1.equals(seq2))

    assertTrue(seq1.equals(seq2.toSeq))
    assertTrue(seq1.sorted.equals(seq1.sorted))
    assertTrue(seq1.equals(seq1.sorted))
  }


}
