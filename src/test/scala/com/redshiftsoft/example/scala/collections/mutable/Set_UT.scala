package com.redshiftsoft.example.scala.collections.mutable

import org.junit.{Assert, Test}

import scala.collection.mutable

class Set_UT {

  @Test
  def add(): Unit = {
    // given
    val fruit = mutable.Set("apple", "orange", "peach", "banana")

    // when
    Assert.assertFalse(fruit.add("peach"))
    Assert.assertTrue(fruit.add("kiwi"))

    // then
    Assert.assertEquals("banana,orange,peach,apple,kiwi", fruit.mkString(","))
  }

  @Test
  def diff(): Unit = {

    // given
    val fruit = mutable.Set("apple", "orange", "peach", "banana")

    // when
    val result = fruit.diff(Set("aa", "bb", "peach"))

    // then
    Assert.assertEquals(Set("apple", "orange", "banana"), result)
    Assert.assertEquals(Set("apple", "orange", "peach", "banana"), fruit)
  }


}
