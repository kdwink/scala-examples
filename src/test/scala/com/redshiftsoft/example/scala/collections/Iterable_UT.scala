package com.redshiftsoft.example.scala.collections


import org.junit.jupiter.api.Assertions.{assertEquals, fail}
import org.junit.jupiter.api.Test

import scala.collection.mutable.ArrayBuffer
import scala.collection.{immutable, mutable}

class Iterable_UT:

  @Test def construct(): Unit =
    val i1 = Iterable("aa", "bb", "cc", "dd", "ee")
    val i2 = immutable.Iterable("aa", "bb", "cc", "dd", "ee")
    val i3 = scala.collection.Iterable("aa", "bb", "cc", "dd", "ee")
    val i4 = mutable.Iterable("aa", "bb", "cc", "dd", "ee")

    assertEquals("scala.collection.immutable.$colon$colon", i1.getClass.getName)
    assertEquals("scala.collection.immutable.$colon$colon", i2.getClass.getName)
    assertEquals("scala.collection.immutable.$colon$colon", i3.getClass.getName)
    assertEquals("scala.collection.mutable.ArrayBuffer", i4.getClass.getName)

  @Test def assignment(): Unit =

    // iterable in mutable can only be assigned mutable
    val i1: mutable.Iterable[String] = ArrayBuffer("a", "b", "c")
    // iterable in immutable can only be assigned immutable
    val i2: immutable.Iterable[String] = Vector("a", "b", "c")

    // iterable in collection can be assigned either
    val i3: scala.collection.Iterable[String] = ArrayBuffer("a", "b", "c")
    val i4: scala.collection.Iterable[String] = Vector("a", "b", "c")

    // Both of the following conversions iterate over the elements and create new data structures.
    val i5: immutable.Iterable[String] = ArrayBuffer("a", "b", "c").toIndexedSeq
    val i6: immutable.Iterable[String] = ArrayBuffer("a", "b", "c").toSeq

  @Test def map_return_type(): Unit =
    val i1 = Iterable("aa", "bb", "cc", "dd", "ee").map(_.toLowerCase())
    val i2 = immutable.Iterable("aa", "bb", "cc", "dd", "ee").map(_.toLowerCase())
    val i3 = scala.collection.Iterable("aa", "bb", "cc", "dd", "ee").map(_.toLowerCase())
    val i4 = mutable.Iterable("aa", "bb", "cc", "dd", "ee").map(_.toLowerCase())

    assertEquals("scala.collection.immutable.$colon$colon", i1.getClass.getName)
    assertEquals("scala.collection.immutable.$colon$colon", i2.getClass.getName)
    assertEquals("scala.collection.immutable.$colon$colon", i3.getClass.getName)
    assertEquals("scala.collection.mutable.ArrayBuffer", i4.getClass.getName)

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // 
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  //noinspection ScalaUnusedExpression
  @Test def head_throws_when_empty(): Unit =
    val list = List()
    try {
      list.head
      fail()
    } catch {
      case e: NoSuchElementException =>
    }

  //noinspection ScalaUnusedExpression
  @Test def tail_throws_when_empty(): Unit =
    val list = List()
    try {
      list.tail
      fail()
    } catch {
      case e: UnsupportedOperationException =>
    }
