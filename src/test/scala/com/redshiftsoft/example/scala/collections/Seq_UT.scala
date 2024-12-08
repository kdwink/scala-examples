package com.redshiftsoft.example.scala.collections


import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

import scala.collection.mutable.ArrayBuffer
import scala.collection.{immutable, mutable}


class Seq_UT {

  @Test def differentSeqs(): Unit = {

    // Just a type alias for scala.collection.immutable.Seq[A]
    // Available without import, this the default if you don't qualify.
    val s1: scala.Seq[Int] = scala.Seq(1, 2, 4, 5, 6, 7)

    // super Trait of immutable and mutable
    val s2: scala.collection.Seq[Int] = scala.collection.Seq[Int](1, 2, 4, 5, 6, 7)

    // mutable Trait: ArrayBuffer is default implementation
    val s3: scala.collection.mutable.Seq[Int] = scala.collection.mutable.Seq[Int](1, 2, 4, 5, 6, 7)
    // immutable Trait: List is default implementation
    val s4: scala.collection.immutable.Seq[Int] = scala.collection.immutable.Seq[Int](1, 2, 4, 5, 6, 7)

    assertEquals("scala.collection.immutable.$colon$colon", s1.getClass.getName)

  }

  @Test def assignment(): Unit = {

    // Seq in mutable can only be assigned mutable
    val i1: mutable.Seq[String] = ArrayBuffer("a", "b", "c")
    // Seq in immutable can only be assigned immutable
    val i2: immutable.Seq[String] = Vector("a", "b", "c")

    // Seq in collection can be assigned either
    val i3: collection.Seq[String] = ArrayBuffer("a", "b", "c")
    val i4: collection.Seq[String] = Vector("a", "b", "c")

    /**
     * Both of the following conversions iterate over the elements and
     * create new data structures.
     */
    val mutableBuffer = ArrayBuffer("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m")
    val i5: immutable.Seq[String] = mutableBuffer.toIndexedSeq
    val i6: immutable.Seq[String] = mutableBuffer.toSeq
  }

  @Test def returnTypeOfMap(): Unit = {
    val i1 = Seq("aa", "bb", "cc", "dd", "ee").map(_.toLowerCase())
    val i2 = immutable.Seq("aa", "bb", "cc", "dd", "ee").map(_.toLowerCase())
    val i3 = collection.Seq("aa", "bb", "cc", "dd", "ee").map(_.toLowerCase())
    val i4 = mutable.Seq("aa", "bb", "cc", "dd", "ee").map(_.toLowerCase())

    assertEquals("scala.collection.immutable.$colon$colon", i1.getClass.getName)
    assertEquals("scala.collection.immutable.$colon$colon", i2.getClass.getName)
    assertEquals("scala.collection.immutable.$colon$colon", i3.getClass.getName)
    assertEquals("scala.collection.mutable.ArrayBuffer", i4.getClass.getName)
  }
}
