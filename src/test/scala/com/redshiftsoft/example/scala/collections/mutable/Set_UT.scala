package com.redshiftsoft.example.scala.collections.mutable

import org.junit.{Assert, Test}

import scala.collection.mutable

class Set_UT {

  @Test
  def test(): Unit = {

    val fruit = mutable.Set("apple", "orange", "peach", "banana")

    Assert.assertFalse(fruit.add("peach"))
    Assert.assertTrue(fruit.add("kiwi"))


    Assert.assertEquals("banana,apple,orange,kiwi,peach", fruit.mkString(","))
  }

}
