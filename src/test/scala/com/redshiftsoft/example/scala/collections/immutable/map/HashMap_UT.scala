package com.redshiftsoft.example.scala.collections.immutable.map

import org.junit.jupiter.api.Assertions.{assertEquals, assertTrue}
import org.junit.jupiter.api.Test

import scala.collection.immutable
import scala.collection.immutable.HashMap

class HashMap_UT:

  @Test def creating_empty(): Unit =
    val map = immutable.HashMap.empty
    assertTrue(map.isEmpty)

  @Test def creating_from(): Unit =
    val map: HashMap[Int, String] = immutable.HashMap.from(List((10, "ten"), (20, "twenty"), (30, "thirty")))
    assertEquals(3, map.size)

  @Test def creating_builder(): Unit =
    val map = immutable.HashMap((10, "ten"), (20, "twenty"), (30, "thirty"))
    assertEquals(3, map.size)
