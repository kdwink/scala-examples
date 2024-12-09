package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.{assertFalse, assertTrue}
import org.junit.jupiter.api.Test


class Any_UT {

  class Person(n: String, a: Int) {
    val name: String = n
    val age: Int = a

    override def equals(other: Any): Boolean = {
      if (!other.isInstanceOf[Person]) return false
      val otherPerson = other.asInstanceOf[Person]
      this.name.equals(otherPerson.name) && Math.abs(age - otherPerson.age) < 10
    }

    override def hashCode: Int = name.hashCode
  }

  val person1 = new Person("keith", 200)
  val person2 = new Person("keith", 205)
  val person3 = new Person("keith", 300)

  /* In scala "==" is equals  */
  @Test def equals(): Unit = {
    assertTrue(person1 == person2)
    assertFalse(person1 == person3)
  }

  /* In scala eq is identity equals  */
  @Test def referenceEquality(): Unit = {
    assertTrue(person1.eq(person1))
    assertFalse(person1.eq(person2))
  }


}