package com.redshiftsoft.example.scala.collections

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IterableOnce_UT:

  @Test def sum(): Unit =
    val numbers = List(1, 2, 3, 4, 5)
    val result = numbers.sum
    assertEquals(15, result)

  @Test def reduce(): Unit =
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = numbers.reduce((a, b) => 1 + a + b)
    assertEquals(53, result)

  @Test def reduce_withPlaceholders(): Unit =
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = numbers.reduce(1 + _ + _)
    assertEquals(53, result)

  //noinspection AccessorLikeMethodIsUnit
  @Test def toMap_1(): Unit =
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


  //noinspection AccessorLikeMethodIsUnit
  @Test def toMap_2(): Unit =

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
