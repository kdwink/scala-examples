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
  // structure
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @Test def head(): Unit =
    val list = Iterable("aaa", "bbb", "ccc")
    assertEquals("aaa", list.head)

  //noinspection ScalaUnusedExpression
  @Test def head_throws_when_empty(): Unit =
    val list = List()
    try {
      list.head
      fail()
    } catch {
      case e: NoSuchElementException =>
    }

  @Test def tail(): Unit =
    val list = Iterable("aaa", "bbb", "ccc", "ddd", "eee", "fff")
    assertEquals("List(bbb, ccc, ddd, eee, fff)", list.tail.toString())

  //noinspection ScalaUnusedExpression
  @Test def tail_throws_when_empty(): Unit =
    val list = List()
    try {
      list.tail
      fail()
    } catch {
      case e: UnsupportedOperationException =>
    }

  @Test def slice(): Unit =
    val nums = collection.mutable.Buffer(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    // when
    val slice1: mutable.Buffer[Int] = nums.slice(4, 7)
    // then
    assertEquals(10, nums.size)
    assertEquals("ArrayBuffer(5, 6, 7)", slice1.toString)

  @Test def take(): Unit =
    // given
    val buffer = collection.mutable.Buffer[String]("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh")
    // when
    val slice1: mutable.Buffer[String] = buffer.take(3)
    // then
    assertEquals("ArrayBuffer(aa, bb, cc)", slice1.toString)
    assertEquals("ArrayBuffer(aa, bb, cc, dd, ee, ff, gg, hh)", buffer.toString)


  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // stream
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @Test def groupBy(): Unit =
    val numbers = Iterable(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val resultMap: Map[Int, Iterable[Int]] = numbers.groupBy(f => f % 2)

    assertEquals(2, resultMap.size)
    assertEquals("List(2, 4, 6, 8)", resultMap(0).toString)
    assertEquals("List(1, 3, 5, 7, 9)", resultMap(1).toString)

  @Test def groupByObject(): Unit =
    // given
    case class X(id: Int, name: String)
    val seq = Seq(
      X(10, "11"),
      X(20, "21"), X(20, "22"),
      X(30, "31"), X(30, "32"), X(30, "33")
    )
    // when
    val map: Map[Int, Seq[X]] = seq.groupBy(_.id)
    // then
    assertEquals(3, map.size)
    assertEquals(1, map(10).size)
    assertEquals(2, map(20).size)
    assertEquals(3, map(30).size)

  @Test def group(): Unit =
    val numbers = Iterable(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5)
    val sizes = numbers.grouped(3).map(list => list.size).toList

    assertEquals("List(3, 3, 3, 3, 1)", sizes.toString)

  @Test def groupMap_combineValues(): Unit =

    val v: Vector[(String, Seq[Long])] = Vector(
      ("aaa", Seq(1, 2, 3)),
      ("bbb", Seq(10, 20, 30)),
      ("aaa", Seq(100, 200, 300)),
      ("bbb", Seq(1000, 2000, 3000)),
      ("aaa", Seq(-10, -20, -30)),
      ("bbb", Seq(-100, -200, -300)),
    )

    // when
    val m1: Map[String, Seq[Seq[Long]]] = v.groupMap(_._1)(_._2)
    val m2: Map[String, Seq[Long]] = m1.view.mapValues(v => v.flatten.distinct).toMap

    // then
    assertEquals(2, m2.size)
    assertEquals(Seq(1, 2, 3, 100, 200, 300, -10, -20, -30), m2("aaa"))
    assertEquals(Seq(10, 20, 30, 1000, 2000, 3000, -100, -200, -300), m2("bbb"))

  @Test def flatten(): Unit =
    // given
    val seq1 = Iterable("aa", "bb")
    val seq2 = Iterable("11", "22")
    val seq3 = Iterable("--", "++")
    val seq4 = Iterable(seq1, seq2, seq3)

    // when
    val flatSeq = seq4.flatten

    // then
    assertEquals(6, flatSeq.size)
    assertEquals("aa,bb,11,22,--,++", flatSeq.mkString(","))
