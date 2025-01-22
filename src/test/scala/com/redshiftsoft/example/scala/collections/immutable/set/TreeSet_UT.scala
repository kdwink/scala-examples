package com.redshiftsoft.example.scala.collections.immutable.set

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

import scala.collection.immutable.TreeSet


class TreeSet_UT:

  @Test def construction(): Unit =
    val set = TreeSet(1, 10, 100, 1_000, 10_000, 20_000, 100_000, 1_000_000, 1_000_000_000)

    assertTrue(set.contains(1_000))
    assertFalse(set.contains(2_000))


