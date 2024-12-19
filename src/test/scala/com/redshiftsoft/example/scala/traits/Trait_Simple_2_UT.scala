package com.redshiftsoft.example.scala.traits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Trait_Simple_2_UT:

  @Test def birds_example(): Unit =
    val flyingBirds: Seq[Flying] = Seq(new Pigeon, new Hawk, new FrigateBird)
    val swimmingBirds: Seq[Swimming] = Seq(new Pigeon, new Hawk, new Penguin)

    flyingBirds.foreach(bird => bird.fly())
    swimmingBirds.foreach(bird => bird.swim())

  @Test def birds_flying_penguin_example(): Unit =
    val flyingPenguin = new Penguin with Flying

    assertEquals(flyingPenguin.fly(), "default fly message")

  @Test def flying(): Unit =
    assertEquals(new Hawk().fly(), "I'm an excellent flyer")
    assertEquals(new FrigateBird().fly(), "I'm an poor flyer")

  @Test def two_traits_same_methods_not_allowed(): Unit =
    trait Flying1:
      def fly(): String = "one"
    trait Flying2:
      def fly(): String = "two"

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
  // Bird Classes
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  abstract class Bird

  class Pigeon extends Bird with Swimming with Flying:
    override val flyMessage = "I'm a good flyer"

  class Hawk extends Bird with Swimming with Flying:
    override val flyMessage = "I'm an excellent flyer"

  class FrigateBird extends Bird with Flying:
    override val flyMessage = "I'm an poor flyer"

  class Penguin extends Bird with Swimming

