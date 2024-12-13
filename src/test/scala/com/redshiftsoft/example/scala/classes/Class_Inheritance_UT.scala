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

  /**
   * https://docs.scala-lang.org/scala3/book/ca-extension-methods.html
   */
  @Test def inheritance_extension(): Unit =
    class A(var field: Long):
      def method1 = "hello 1"

      def method2 = "hello 2"

    extension (a: A)
      def method3: Long = 42L
      def method4: Long = 142L
      def incrementField(): Unit = {
        a.field = a.field + 1_000
      }

    val a = new A(300)
    a.incrementField()
    assertEquals("hello 1", a.method1)
    assertEquals(42, a.method3)
    assertEquals(142, a.method4)
    assertEquals(1_300, a.field)


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
