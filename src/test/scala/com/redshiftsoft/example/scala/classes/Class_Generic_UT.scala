package com.redshiftsoft.example.scala.classes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * https://docs.scala-lang.org/tour/generic-classes.html
 *
 * https://docs.scala-lang.org/scala3/book/types-generics.html
 */
class Class_Generic_UT:

  class Stack[A]:
    private var elements: List[A] = Nil

    def push(x: A): Unit =
      elements = x :: elements

    def peek: A = elements.head

    def pop(): A =
      val currentTop = peek
      elements = elements.tail
      currentTop

  @Test def example_string(): Unit =
    // given
    val s = Stack[String]()
    s.push("aaa")
    s.push("bbb")
    s.push("ccc")

    // when
    val answer = (s.pop(), s.pop(), s.pop())

    // then
    assertEquals(("ccc", "bbb", "aaa"), answer)

  @Test def example_long(): Unit =
    // given
    val s = Stack[Long]()
    s.push(10L)
    s.push(20L)
    s.push(30L)

    // when
    val answer = (s.pop(), s.pop(), s.pop())

    // then
    assertEquals((30L, 20L, 10L), answer)