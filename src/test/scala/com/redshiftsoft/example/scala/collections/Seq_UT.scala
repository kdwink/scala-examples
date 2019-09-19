package com.redshiftsoft.example.scala.collections

import org.junit.Assert.assertEquals
import org.junit.Test

class Seq_UT {

  @Test def constructor(): Unit = {
    // given
    val x = Seq("one", "two", "three")

    // then
    assertEquals(3, x.size)
    assertEquals("scala.collection.immutable.$colon$colon", x.getClass.getName)

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
    val seq1 = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val seq2 = Seq(4, 5, 6)

    val diff = seq1.diff(seq2)

    assertEquals("1,2,3,7,8,9,10", diff.mkString(","))
  }



}
