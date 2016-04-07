package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Objects_UT {

  @Test
  def basicUsage(): Unit = {

    object MyObject {
      val WHATEVER = 100
      var age: Int = 10
      var name: String = "george"
    }

    MyObject.age = 20
    MyObject.name = "keith"

  }

  @Test
  def apply(): Unit = {

    object MyObject {
      val WHATEVER = 100
      var age: Int = 10
      var name: String = "george"

      def apply(s: String): Unit = {
        this.name = s
      }
    }

    MyObject("Stuff")
    Assert.assertEquals("Stuff", MyObject.name)

  }

}
