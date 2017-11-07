package com.redshiftsoft.example.scala.collections.mutable

import org.junit.{Assert, Test}

import scala.collection.mutable

class HashMap_UT {

  @Test def put(): Unit = {
    val map: mutable.Map[String, String] = mutable.HashMap.empty
    map.put("key1", "value1")
    Assert.assertEquals(1, map.size)
  }

  @Test def passMutableMap(): Unit = {
    // given
    val map: mutable.Map[String, Double] = mutable.HashMap.empty
    // when/then
    iTakeMutableMap(map)
    iTakeImmutableMap1(map.toMap)
    iTakeImmutableMap2(map.toMap)
  }


  private def iTakeMutableMap(m: mutable.Map[String, Double]): Unit = {

  }

  private def iTakeImmutableMap1(m: collection.immutable.Map[String, Double]): Unit = {

  }

  private def iTakeImmutableMap2(m: Map[String, Double]): Unit = {

  }

}
