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
  def objectApplyAsFactoryPattern(): Unit = {

    class MyObject {
      val WHATEVER = 100
      var age: Int = 10
      var name: String = "george"


    }
    object MyObject {

      def apply(s: String): MyObject = {
        val m = new MyObject
        m.name = s
        m
      }
    }

    val s = MyObject("Keith")

    Assert.assertEquals("Keith", s.name)
  }

}
