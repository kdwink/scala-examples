package com.redshiftsoft.example.scala.collections

import org.junit.{Assert, Test}

import scala.collection.mutable.ArrayBuffer
import scala.collection.{immutable, mutable}

class Iterable_UT {

  @Test def construct(): Unit = {
    val i1 = Iterable("aa", "bb", "cc", "dd", "ee")
    val i2 = immutable.Iterable("aa", "bb", "cc", "dd", "ee")
    val i3 = mutable.Iterable("aa", "bb", "cc", "dd", "ee")

    Assert.assertEquals("scala.collection.immutable.$colon$colon", i1.getClass.getName)
    Assert.assertEquals("scala.collection.immutable.$colon$colon", i2.getClass.getName)
    Assert.assertEquals("scala.collection.mutable.ArrayBuffer", i3.getClass.getName)
  }

  @Test def assignment(): Unit = {

    val i1: mutable.Iterable[String] = ArrayBuffer("a", "b", "c")
    val i2: immutable.Iterable[String] = Vector("a", "b", "c")

    /**
     * Both of the following conversions iterate over the elements and
     * create new data structures.
     */
    val i4: immutable.Iterable[String] = ArrayBuffer("a", "b", "c").toIndexedSeq
    val i5: immutable.Iterable[String] = ArrayBuffer("a", "b", "c").toSeq
  }
}