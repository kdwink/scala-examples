package com.redshiftsoft.example.scala.classes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


/**
 * https://docs.scala-lang.org/scala3/book/ca-extension-methods.html
 */
class Class_Inheritance_Extension_UT:

  class A(var field: Long):
    def method1 = "hello 1"

    def method2 = "hello 2"

  extension (a: A)
    def method3: Long = 42L
    def method4: Long = 142L
    def incrementField(): Unit =
      a.field = a.field + 1_000

  @Test def inheritance_extension(): Unit =

    val a = new A(300)
    a.incrementField()
    assertEquals("hello 1", a.method1)
    assertEquals(42, a.method3)
    assertEquals(142, a.method4)
    assertEquals(1_300, a.field)
