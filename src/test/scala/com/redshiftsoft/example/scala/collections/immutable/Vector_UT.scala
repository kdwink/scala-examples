package com.redshiftsoft.example.scala.collections.immutable

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test


/**
 * Vector, an immutable Seq, which, unlike List, provides constant time implementations of all methods.
 */
class Vector_UT {

  @Test def construction(): Unit = {

    val v1 = Vector(1, 2, 3)
    val v2 = Vector(10, 20, 30)

    val v3 = v1 ++ v2

    assertEquals("scala.collection.immutable.Vector1", v3.getClass.getName)
    assertEquals("Vector(1, 2, 3, 10, 20, 30)", v3.toString())
  }

  //noinspection AccessorLikeMethodIsUnit
  @Test def toMap_1(): Unit = {

    val v: Vector[(String, Long)] = Vector(
      ("aaa", 1),
      ("bbb", 10),
      ("aaa", 2),
      ("bbb", 20),
      ("aaa", 3),
      ("bbb", 30),
    )

    // when
    val m: Map[String, Long] = v.toMap

    // then
    assertEquals(2, m.size)
    assertEquals(3, m("aaa"))
    assertEquals(30, m("bbb"))
  }


  //noinspection AccessorLikeMethodIsUnit
  @Test def toMap_2(): Unit = {

    val v: Vector[(String, Seq[Long])] = Vector(
      ("aaa", Seq(1, 2, 3)),
      ("bbb", Seq(10, 11, 12)),
      ("aaa", Seq(4, 5, 6)),
      ("bbb", Seq(13, 14, 15))
    )

    // when
    val m: Map[String, Seq[Long]] = v.toMap

    // then
    assertEquals(2, m.size)
    assertEquals(Seq(4, 5, 6), m("aaa"))
    assertEquals(Seq(13, 14, 15), m("bbb"))
  }

  @Test def groupMap(): Unit = {

    val v: Vector[(String, Long)] = Vector(
      ("aaa", 1),
      ("bbb", 10),
      ("aaa", 2),
      ("bbb", 20),
      ("aaa", 3),
      ("bbb", 30),
    )

    // when
    val m: Map[String, Seq[Long]] = v.groupMap(_._1)(_._2)

    // then
    assertEquals(2, m.size)
    assertEquals(Seq(1, 2, 3), m("aaa"))
    assertEquals(Seq(10, 20, 30), m("bbb"))
  }

  @Test def groupMap_combineValues(): Unit = {

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
  }

}
