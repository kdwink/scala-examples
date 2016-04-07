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


}
