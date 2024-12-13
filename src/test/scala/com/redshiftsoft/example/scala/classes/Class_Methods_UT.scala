package com.redshiftsoft.example.scala.classes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Class_Methods_UT:

  /**
   * A suggestion about methods that take no parameters
   *
   * When a method takes no parameters, it’s said to have an arity level of arity-0. Similarly, when a method takes one 
   * parameter it’s an arity-1 method. When you create arity-0 methods:
   *
   * If the method performs side effects, such as calling println, declare the method with empty parentheses
   *
   * If the method does not perform side effects—such as getting the size of a collection, which is similar to 
   * accessing a field on the collection—leave the parentheses off
   */
  @Test def arity_zero(): Unit =

    class Example:
      def speak(): Unit = println("hi")

      def name: String = "example"

    val e = Example();
    e.speak()
    assertEquals("example", e.name)
