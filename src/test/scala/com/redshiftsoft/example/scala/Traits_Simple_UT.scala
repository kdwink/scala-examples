package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

/**
  * A trait encapsulates method and field definitions, which can then be reused by mixing them into classes. Unlike
  * class inheritance, in which each class must inherit from just one superclass, a class can mix in any number of
  * traits.
  *
  * Traits are used to define object types by specifying the signature of the supported methods. Scala also allows
  * traits to be partially implemented but traits may not have constructor parameters.
  */
class Traits_Simple_UT {

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
    Assert.assertTrue(person.isAdult())
  }

}
