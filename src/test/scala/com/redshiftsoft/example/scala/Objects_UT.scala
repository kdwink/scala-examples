package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test


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

  /* Companion object can access private fields of class. */
  @Test
  def objectApplyAsFactoryPattern(): Unit = {

    class MyObject {
      val WHATEVER = 100
      private var age: Int = 10
      private var name: String = "george"

      def getName: String = {
        name
      }
    }
    object MyObject {

      def apply(s: String): MyObject = {
        val m = new MyObject
        m.name = s
        m.age = 100
        m
      }
    }

    val s = MyObject("Keith")

    assertEquals("Keith", s.getName)
  }

}
