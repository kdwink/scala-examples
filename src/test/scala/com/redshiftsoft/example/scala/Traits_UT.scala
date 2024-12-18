package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test


class Traits_UT:

  @Test def birdsExample(): Unit =
    val flyingBirds: Seq[Flying] = Seq(
      new Pigeon,
      new Hawk,
      new Frigatebird)

    flyingBirds.foreach(bird => bird.fly())

    val swimmingBirds: Seq[Swimming] = Seq(
      new Pigeon,
      new Hawk,
      new Penguin)

    swimmingBirds.foreach(bird => bird.swim())

  @Test def birdsFlyingPenguinExample(): Unit = 
    val flyingPenguin = new Penguin with Flying

    assertEquals(flyingPenguin.fly(), "default fly message")

  @Test def flying(): Unit = 
    assertEquals(new Hawk().fly(), "I'm an excellent flyer")
    assertEquals(new Frigatebird().fly(), "I'm an poor flyer")

  @Test def twoTraitsSameProps(): Unit = 
    trait Flying1 {
      def fly(): String = "one"
    }
    trait Flying2 {
      def fly(): String = "two"
    }

    val x1 = new Object with Flying1
    val x2 = new Object with Flying2
    // DOES NOT COMPILE: val x3 = new Object with Flying1 with Flying2

    assertEquals(x1.fly(), "one")
    assertEquals(x2.fly(), "two")

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // Traits
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  trait Swimming:
    def swim(): Unit = println("I'm swimming")

  trait Flying:
    def flyMessage: String = "default fly message"

    def fly(): String = flyMessage

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // Birds
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  abstract class Bird

  class Pigeon extends Bird with Swimming with Flying:
    override val flyMessage = "I'm a good flyer"

  class Hawk extends Bird with Swimming with Flying:
    override val flyMessage = "I'm an excellent flyer"

  class Frigatebird extends Bird with Flying:
    override val flyMessage = "I'm an poor flyer"

  class Penguin extends Bird with Swimming

