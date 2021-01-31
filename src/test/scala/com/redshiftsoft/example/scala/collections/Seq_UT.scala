package com.redshiftsoft.example.scala.collections

import org.junit.{Assert, Test}

import scala.collection.mutable.ArrayBuffer
import scala.collection.{immutable, mutable}

class Seq_UT {

  @Test def assignment(): Unit = {

    // Seq in mutable can only be assigned mutable
    val i1: mutable.Seq[String] = ArrayBuffer("a", "b", "c")
    // Seq in immutable can only be assigned immutable
    val i2: immutable.Seq[String] = Vector("a", "b", "c")

    // Seq in collection can be assigned either
    val i3: scala.collection.Seq[String] = ArrayBuffer("a", "b", "c")
    val i4: scala.collection.Seq[String] = Vector("a", "b", "c")

    /**
     * Both of the following conversions iterate over the elements and
     * create new data structures.
     */
    val i5: immutable.Seq[String] = ArrayBuffer("a", "b", "c").toIndexedSeq
    val i6: immutable.Seq[String] = ArrayBuffer("a", "b", "c").toSeq
  }
}