package com.redshiftsoft.example.scala.collections

import org.junit.{Assert, Test}

/**
  * Vector, an immutable Seq, which, unlike List, provides constant time implementations of all methods.
  */
class Vector_UT {

  @Test def construction(): Unit = {

    val v1 = Vector(1, 2, 3)
    val v2 = Vector(10, 20, 30)

    val v3 = v1 ++ v2

    Assert.assertEquals("scala.collection.immutable.Vector", v3.getClass.getName)
    Assert.assertEquals("Vector(1, 2, 3, 10, 20, 30)", v3.toString())
  }

}
