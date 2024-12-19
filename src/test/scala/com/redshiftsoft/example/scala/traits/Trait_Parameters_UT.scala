package com.redshiftsoft.example.scala.traits

import org.junit.jupiter.api.Test

class Trait_Parameters_UT:

  @Test def scala_3_traits_can_have_parameters(): Unit =
    trait Greeting(val name: String):
      def msg = s"How are you, $name"

    class C extends Greeting("Bob"):
      println(msg)

  @Test def traits_with_parameters_must_be_extended_directly_not_via_sub_trait(): Unit =
    trait T1(val name: String):
      def isFoo1: Boolean = true

      def msg = s"How are you, $name"

    trait T2 extends T1:
      override def isFoo1: Boolean = true

      def isFoo2: Boolean = true

    trait T3 extends T2:
      override def isFoo1: Boolean = true

      override def isFoo2: Boolean = true

      def isFoo3: Boolean = false

    class C1 extends T1("hi")
    class C2 extends T2, T1("hi")
    class C3 extends T3, T1("hi")
