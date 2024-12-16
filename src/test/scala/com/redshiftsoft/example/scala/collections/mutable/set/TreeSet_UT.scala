package com.redshiftsoft.example.scala.collections.mutable.set

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

import scala.collection.mutable
import scala.collection.mutable.TreeSet
import scala.util.Random


class TreeSet_UT:

  @Test def construction(): Unit =
    val set = mutable.TreeSet(1, 10, 100, 1000, 10000)

    assertTrue(set.contains(1000))
    assertFalse(set.contains(2000))

  @Test def speed(): Unit =

    //val collection = scala.collection.mutable.Set("")
    val collection = mutable.TreeSet.empty[String]
    val startTime = System.currentTimeMillis()

    for (i <- 1 to 20_000) collection.add(String.valueOf(Random.nextLong()))

    for (i <- 1 to 20_000) {
      val value: String = String.valueOf(Random.nextLong())
      if (collection.contains(value)) printf("yes")
    }

    printf("elapsed: " + (System.currentTimeMillis() - startTime))
