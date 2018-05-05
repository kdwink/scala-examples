package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Traits_UT {

  trait Person {
    def isChild(x: Any): Boolean

    def isAdult(x: Any): Boolean = !isChild(x)
  }

  class Teacher extends Person {
    override def isChild(x: Any): Boolean = false
  }

  @Test
  def polymorphism(): Unit = {
    val person: Person = new Teacher
    Assert.assertFalse(person.isChild())
  }

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  // Birds examples
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  abstract class Bird {
  }

  trait Swimming {
    def swim(): Unit = println("I'm swimming")
  }

  trait Flying {
    def flyMessage: String = ""

    def fly(): Unit = println(flyMessage)
  }

  class Pigeon extends Bird with Swimming with Flying {
    override val flyMessage = "I'm a good flyer"
  }

  class Hawk extends Bird with Swimming with Flying {
    override val flyMessage = "I'm an excellent flyer"
  }

  class Frigatebird extends Bird with Flying {
    override val flyMessage = "I'm an excellent flyer"
  }

  class Penguin extends Bird with Swimming

  @Test def birdsExample(): Unit = {
    val flyingBirds = List(
      new Pigeon,
      new Hawk,
      new Frigatebird)

    flyingBirds.foreach(bird => bird.fly())

    val swimmingBirds = List(
      new Pigeon,
      new Hawk,
      new Penguin)

    swimmingBirds.foreach(bird => bird.swim())
  }

  @Test def birdsFlyingPenguinExample(): Unit = {
    val flyingPenguin = new Penguin with Flying
    flyingPenguin.fly()
  }

}