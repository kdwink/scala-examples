package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * https://docs.scala-lang.org/scala3/book/taste-objects.html
 */
class Class_Objects_Companion_UT {

  /* Companion object can access private fields of class. */
  @Test
  def objectApplyAsFactoryPattern(): Unit = {

    class MyClass {
      val WHATEVER = 100
      private var age: Int = 10
      private var name: String = "george"

      def getName: String = {
        name
      }
    }
    object MyClass {

      def apply(s: String): MyClass = {
        val m = new MyClass
        m.name = s
        m.age = 100
        m
      }
    }

    val s = MyClass("Keith")

    assertEquals("Keith", s.getName)
  }

}
