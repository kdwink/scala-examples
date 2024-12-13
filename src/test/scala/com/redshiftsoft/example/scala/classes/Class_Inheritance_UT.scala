package com.redshiftsoft.example.scala.classes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Class_Inheritance_UT:

  @Test def inheritance(): Unit =
    class A:
      def method1 = "hello 1"

      def method2 = "hello 2"

    class B extends A:
      override def method2 = "hello B"

    class C extends B

    val c = new C
    assertEquals("hello 1", c.method1)
    assertEquals("hello B", c.method2)

  @Test def polymorphism(): Unit =
    class A {
      def method1 = "hello 1"

      def method2 = "hello 2"
    }
    class B extends A {
      override def method2 = "hello B"
    }
    class C extends B

    val c1: A = new C
    val c2: B = new C
    val c3: C = new C
    assertEquals("hello B", c1.method2)
    assertEquals("hello B", c1.method2)
    assertEquals("hello B", c1.method2)
