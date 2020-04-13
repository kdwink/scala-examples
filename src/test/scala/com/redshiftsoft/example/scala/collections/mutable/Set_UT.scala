package com.redshiftsoft.example.scala.collections.mutable

import org.junit.{Assert, Test}

import scala.collection.mutable

class Set_UT {

  @Test
  def add(): Unit = {

    // when
    val fruit = mutable.Set("apple", "orange", "peach", "banana")

    // when
    Assert.assertFalse(fruit.add("peach"))
    Assert.assertTrue(fruit.add("kiwi"))

    // then
    Assert.assertEquals("banana,apple,orange,kiwi,peach", fruit.mkString(","))
  }

}
