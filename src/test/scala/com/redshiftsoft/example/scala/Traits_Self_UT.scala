package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

/**
  * Trait self types are Traits that require that they can only ever be mixed into a class which is a subtype of
  * a specified class.
  */
class Traits_Self_UT {

  @Test def test(): Unit = {

    class A {
      def hi = "hi"
    }

    /* 'self' here can actually be any identifier */
    trait B {
      self: A =>
      override def toString = "B: " + hi
    }

    class C extends A with B

    val c: C = new C

    Assert.assertEquals("B: hi", c.toString)
  }

}
