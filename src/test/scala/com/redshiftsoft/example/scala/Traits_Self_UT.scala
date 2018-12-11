package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

/**
  * Trait self types are Traits that require that they can only ever be mixed into a class which is a subtype of
  * a specified class.
  */
class Traits_Self_UT {

  @Test def test(): Unit = {

    class A(lastName: String) {
      def hi(firstName: String): String = s"hi $lastName,$firstName"
    }

    /* B can't extend A directly because A has parameters. 'self' here can actually be any identifier */
    trait B {
      self: A =>
      override def toString: String = "B: " + hi("Bob")
    }

    class C(name: String) extends A(name) with B

    val c: C = new C("Smith")

    Assert.assertEquals("B: hi Smith,Bob", c.toString)
  }

}
