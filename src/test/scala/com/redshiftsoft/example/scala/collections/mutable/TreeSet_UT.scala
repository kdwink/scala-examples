package com.redshiftsoft.example.scala.collections.mutable

import org.junit.{Assert, Test}

import scala.collection.mutable.TreeSet
import scala.util.Random


class TreeSet_UT {

  @Test def construction(): Unit = {
    val set = TreeSet(1, 10, 100, 1000, 10000)

    Assert.assertTrue(set.contains(1000))
    Assert.assertFalse(set.contains(2000))
  }

  @Test def speed(): Unit = {

    //val collection = scala.collection.mutable.Set("")
    val collection = TreeSet.empty[String]


    val startTime = System.currentTimeMillis()

    for (i <- 1 to 20000) {
      val value: String = String.valueOf(Random.nextLong())
      collection.add(value)
    }

    for (i <- 1 to 20000) {
      val value: String = String.valueOf(Random.nextLong())
      if (collection.contains(value)) {
        printf("yes")
      }
    }

    printf("elapsed: " + (System.currentTimeMillis() - startTime))
  }

}
