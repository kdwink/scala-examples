package com.redshiftsoft.example.scala.collections

import org.junit.Test

import scala.collection.mutable.TreeSet
import scala.util.Random


class TreeSet_UT {

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
