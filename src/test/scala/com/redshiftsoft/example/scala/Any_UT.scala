package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Any_UT {

  class Person(n: String, a: Int) {
    val name: String = n
    val age: Int = a

    override def equals(other: Any): Boolean = {
      if (!other.isInstanceOf[Person]) return false
      val otherPerson = other.asInstanceOf[Person]
      this.name.equals(otherPerson.name) && Math.abs(age - otherPerson.age) < 10
    }

    override def hashCode = name.hashCode
  }

  /* In scala "==" is equals  */
  @Test def equals(): Unit = {
    val person1 = new Person("keith", 200)
    val person2 = new Person("keith", 205)
    val person3 = new Person("keith", 300)

    Assert.assertTrue(person1 == person2)
    Assert.assertFalse(person1 == person3)
  }

}