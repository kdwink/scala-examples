package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

/**
  * Array is not a member of the Scala collections.  It is provided for JVM compatibility.
  *
  * Array is mutable.
  */
class Array_UT {

  @Test def example(): Unit = {

    val colors = Array("red", "green", "blue")
    colors(0) = "purple"

    Assert.assertEquals("purple", colors(0))
  }

}
