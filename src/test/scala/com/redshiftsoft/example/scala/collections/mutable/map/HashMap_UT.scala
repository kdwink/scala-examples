package com.redshiftsoft.example.scala.collections.mutable.map

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import scala.collection.mutable

class HashMap_UT:

  @Test def put(): Unit =
    val map: mutable.Map[String, String] = mutable.HashMap.empty
    map.put("key1", "value1")
    assertEquals(1, map.size)

  @Test def passMutableMap(): Unit =
    // given
    val map: mutable.Map[String, Double] = mutable.HashMap.empty
    // when/then
    iTakeMutableMap(map)
    iTakeImmutableMap1(map.toMap)
    iTakeImmutableMap2(map.toMap)

  @Test def from(): Unit =
    val immutable = Map(1 -> 'a', 2 -> 'b', 3 -> 'c', 4 -> 'd', 5 -> 'e', 6 -> 'f')
    val hashMap = scala.collection.mutable.Map.from(immutable)

    assertEquals("scala.collection.mutable.HashMap", hashMap.getClass.getName)
    assertEquals(6, hashMap.size)


  private def iTakeMutableMap(m: mutable.Map[String, Double]): Unit = {
  }

  private def iTakeImmutableMap1(m: collection.immutable.Map[String, Double]): Unit = {

  }

  private def iTakeImmutableMap2(m: Map[String, Double]): Unit = {

  }
