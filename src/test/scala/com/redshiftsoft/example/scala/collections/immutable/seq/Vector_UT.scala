package com.redshiftsoft.example.scala.collections.immutable.seq

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test


/**
 * Vector, an immutable Seq, which, unlike List, provides constant time implementations of all methods.
 */
class Vector_UT:

  @Test def construction(): Unit =

    val v1 = Vector(1, 2, 3)
    val v2 = Vector(10, 20, 30)

    val v3 = v1 ++ v2

    assertEquals("scala.collection.immutable.Vector1", v3.getClass.getName)
    assertEquals("Vector(1, 2, 3, 10, 20, 30)", v3.toString())

  @Test def groupMap(): Unit =

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

