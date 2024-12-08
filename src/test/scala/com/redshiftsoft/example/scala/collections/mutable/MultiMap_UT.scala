package com.redshiftsoft.example.scala.collections.mutable

import org.junit.jupiter.api.Test

import scala.collection.mutable
import scala.collection.mutable.{HashMap, MultiMap, Set}

class MultiMap_UT {

  @Test
  def test(): Unit = {

    // first import all necessary types from package `collection.mutable`

    // to create a `MultiMap` the easiest way is to mixin it into a normal `Map` instance
    val mm: mutable.HashMap[Int, mutable.Set[String]] with mutable.MultiMap[Int, String]
    = new mutable.HashMap[Int, mutable.Set[String]] with mutable.MultiMap[Int, String]

    // to add key-value pairs to a multimap it is important to use
    // the method `addBinding` because standard methods like `+` will
    // overwrite the complete key-value pair instead of adding the
    // value to the existing key
    mm.addBinding(1, "a")
    mm.addBinding(2, "b")
    mm.addBinding(1, "c")

    // mm now contains `Map(2 -> Set(b), 1 -> Set(c, a))`

    // to check if the multimap contains a value there is method `entryExists`, which allows to traverse the including set
    mm.entryExists(1, _ == "a") == true
    mm.entryExists(1, _ == "b") == false
    mm.entryExists(2, _ == "b") == true

    // to remove a previous added value there is the method `removeBinding`
    mm.removeBinding(1, "a")
    mm.entryExists(1, _ == "a") == false

  }


}
