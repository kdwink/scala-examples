package com.redshiftsoft.example.scala.collections.immutable

import org.junit.{Assert, Test}

import scala.collection.immutable.TreeSet


class TreeSet_UT {

  @Test def construction(): Unit = {
    val set = TreeSet(1, 10, 100, 1000, 10000)

    Assert.assertTrue(set.contains(1000))
    Assert.assertFalse(set.contains(2000))
  }


}
