package com.redshiftsoft.example.scala.collections.mutable.map

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import scala.collection.mutable

class HashMap_UT:

  @Test def creating_from(): Unit =
    val immutable = Map(1 -> 'a', 2 -> 'b', 3 -> 'c', 4 -> 'd', 5 -> 'e', 6 -> 'f')
    val hashMap = scala.collection.mutable.Map.from(immutable)

    assertEquals("scala.collection.mutable.HashMap", hashMap.getClass.getName)
    assertEquals(6, hashMap.size)

  @Test def put(): Unit =
    val map: mutable.Map[String, String] = mutable.HashMap.empty
    map.put("key1", "value1")
    assertEquals(1, map.size)

  @Test def pass_mutable_map(): Unit =
    // given
    def iTakeMutableMap(m: mutable.Map[String, Double]): Unit = None

    def iTakeImmutableMap1(m: collection.immutable.Map[String, Double]): Unit = None

    def iTakeImmutableMap2(m: Map[String, Double]): Unit = None

    val iAmMutable: mutable.Map[String, Double] = mutable.HashMap.empty

    // when/then
    iTakeMutableMap(iAmMutable)
    iTakeImmutableMap1(iAmMutable.toMap)
    iTakeImmutableMap2(iAmMutable.toMap)



