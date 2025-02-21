package com.redshiftsoft.example.scala.classes

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

/**
 * https://docs.scala-lang.org/scala3/book/taste-objects.html
 */
class Class_Object_Singleton_UT:

  @Test
  def mostBasicUsage(): Unit =

    object MyObject:
      val WHATEVER = 100
      var age: Int = 10
      var name: String = "george"

    MyObject.age = 20
    MyObject.name = "keith"


  @Test
  def singleInstanceOfClass(): Unit =

    class MyClass(name: String, age: Int):
      def calculate(x: Int): String = name + "->" + (age * x)

    object MyClass extends MyClass("George", 42):
      val Whatever = 100

    assertEquals(100, MyClass.Whatever)
    assertEquals("George->420", MyClass.calculate(10))

