package com.redshiftsoft.example.scala.collections.immutable

import org.junit.{Assert, Test}

import scala.collection.immutable.HashSet


class HashSet_UT {

  @Test def construction(): Unit = {
    val set = HashSet(1, 10, 100, 1000, 10000)

    Assert.assertTrue(set.contains(1000))
    Assert.assertFalse(set.contains(2000))
  }


}
