package com.redshiftsoft.example.scala.collections.mutable.set

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

import scala.collection.mutable

class Set_UT:

  @Test
  def add(): Unit =
    // given
    val fruit = mutable.Set("apple", "orange", "peach", "banana")

    // when
    assertFalse(fruit.add("peach"))
    assertTrue(fruit.add("kiwi"))

    // then
    assertEquals("banana,orange,peach,apple,kiwi", fruit.mkString(","))

  @Test
  def diff(): Unit =

    // given
    val fruit = mutable.Set("apple", "orange", "peach", "banana")

    // when
    val result = fruit.diff(Set("aa", "bb", "peach"))

    // then
    assertEquals(Set("apple", "orange", "banana"), result)
    assertEquals(Set("apple", "orange", "peach", "banana"), fruit)


