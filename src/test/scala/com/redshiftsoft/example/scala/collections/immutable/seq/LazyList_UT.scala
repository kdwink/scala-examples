package com.redshiftsoft.example.scala.collections.immutable.seq

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class LazyList_UT:

  def fibFrom(a: Int, b: Int): LazyList[Int] = a #:: fibFrom(b, a + b)

  @Test def bounded(): Unit =

    //noinspection SimplifyBooleanMatch
    def to(head: Char, end: Char): LazyList[Char] = head > end match
      case true => LazyList.empty
      case false => head #:: to((head + 1).toChar, end)

    assertEquals(List('a', 'b', 'c', 'd', 'e', 'f'), to('a', 'f'))
    assertEquals(List(), to('f', 'a'))

  @Test def take(): Unit =

    def inc1(i: Int): LazyList[Int] = LazyList.cons(i, inc1(i + 1))

    def inc2(i: Int): LazyList[Int] = i #:: inc2(i + 1)

    val streamResult1 = inc1(1)
    val streamResult2 = inc1(1)

    assertEquals(List(1, 2, 3, 4, 5), streamResult1.take(5).toList)
    assertEquals(List(1, 2, 3, 4, 5), streamResult2.take(5).toList)

  @Test def takeWhile(): Unit =
    val streamResult = fibFrom(1, 1)
    assertEquals(List(1, 1, 2, 3, 5, 8, 13, 21), streamResult.takeWhile(_ < 30).toList)

    val streamResult2 = List(1, 2, 3, 232, 32, 4, 4_000, 5_000).to(LazyList)
    assertEquals(List(1, 2, 3, 232, 32, 4), streamResult2.takeWhile(_ < 1_000).toList)

  @Test def find(): Unit =
    val streamResult = fibFrom(1, 1)
    assertEquals(List(1, 1, 2, 3, 5, 8, 13), streamResult.take(7).toList)

    val found: Option[Int] = streamResult.find(_ > 10)
    assertEquals(13, found.get)

