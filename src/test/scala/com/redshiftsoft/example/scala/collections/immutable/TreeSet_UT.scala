package com.redshiftsoft.example.scala.collections.immutable

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

import scala.collection.immutable.TreeSet


class TreeSet_UT {

  @Test def construction(): Unit = {
    val set = TreeSet(1, 10, 100, 1000, 10000)

    assertTrue(set.contains(1000))
    assertFalse(set.contains(2000))
  }


}
