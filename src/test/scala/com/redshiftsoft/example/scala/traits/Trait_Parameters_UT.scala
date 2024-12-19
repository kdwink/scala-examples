package com.redshiftsoft.example.scala.traits

import org.junit.jupiter.api.Test

class Trait_Parameters_UT:

  @Test def scala_3_traits_can_have_parameters() : Unit =
    trait Greeting(val name: String):
      def msg = s"How are you, $name"

    class C extends Greeting("Bob"):
      println(msg)