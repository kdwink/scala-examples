package com.redshiftsoft.example.scala


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import scala.collection.mutable.ListBuffer

class Control_For_UT:

  @Test def for_do_1(): Unit =
    var count = 0
    for x <- 1 to 10 do
      count = count + x
    assertEquals(55, count)

  @Test def for_do_2(): Unit =
    val elements = Seq("a", "bb", "ccc", "dddd", "eeeee", "ffffff")
    var i = 0
    for e <- elements do i = i + 1
    assertEquals(6, i)

  @Test def for_do_1_to_1(): Unit =
    var count = 0
    for x <- 1 to 1 do
      count = count + x
    assertEquals(1, count)

  @Test def for_do_guard(): Unit =
    val result = ListBuffer.empty[Int]
    for x <- 1 to 10 if x % 3 == 0 do
      result.append(x)
    assertEquals(Seq(3, 6, 9), result.toSeq)

  @Test def for_do_sequence(): Unit =
    val seq = Seq("a", "bb", "ccc", "dddd", "eeeee")
    val buffer = ListBuffer.empty[String]
    for x <- seq.reverse do
      buffer.append(x)
    assertEquals(Seq("eeeee", "dddd", "ccc", "bb", "a"), buffer.toSeq)

  @Test def for_do_sequence_index(): Unit =
    val seq = Seq("a", "bb", "ccc", "dddd", "eeeee")
    val buffer = ListBuffer.empty[String]
    for i <- seq.indices do
      buffer.append(seq(i))
    assertEquals(Seq("a", "bb", "ccc", "dddd", "eeeee"), buffer.toSeq)

  @Test def for_do_multi_line(): Unit =
    val seq = Seq("a", "bb", "ccc", "dddd", "eeeee")
    var i = 0
    var j = 0
    for s <- seq do
      i = i + 1
      j = j + 1
    assertEquals(5, i)
    assertEquals(5, j)