package com.redshiftsoft.example.scala.classes

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

/**
 * https://docs.scala-lang.org/scala3/book/taste-objects.html
 */
class Class_Object_Singleton_UT:

  @Test
  def basicUsage(): Unit =

    object MyObject:
      val WHATEVER = 100
      var age: Int = 10
      var name: String = "george"

    MyObject.age = 20
    MyObject.name = "keith"


