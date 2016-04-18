package com.redshiftsoft.example.scala.collections.mutable

import org.junit.{Assert, Test}

import scala.collection.mutable

class HashMap_UT {

  @Test def put(): Unit = {
    val map: mutable.Map[String, String] = mutable.HashMap.empty
    map.put("key1", "value1")
    Assert.assertEquals(1, map.size)
  }

}
