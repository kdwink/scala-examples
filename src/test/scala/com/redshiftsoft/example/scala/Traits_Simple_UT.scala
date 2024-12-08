package com.redshiftsoft.example.scala


import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

import scala.collection.mutable.ArrayBuffer


/**
 * A trait encapsulates method and field definitions, which can then be reused by mixing them into classes. Unlike
 * class inheritance, in which each class must inherit from just one superclass, a class can mix in any number of
 * traits.
 *
 * Traits are used to define object types by specifying the signature of the supported methods. Scala also allows
 * traits to be partially implemented but traits may not have constructor parameters.
 */
class Traits_Simple_UT {

  @Test
  def polymorphism(): Unit = {

    trait Person {
      def isChild(x: Any): Boolean

      def isAdult(x: Any): Boolean = !isChild(x)
    }

    class Teacher extends Person {
      override def isChild(x: Any): Boolean = false
    }

    val person: Person = new Teacher
    assertFalse(person.isChild("x"))
    assertTrue(person.isAdult("x"))
  }

  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  @Test
  def fields(): Unit = {
    trait Pet {
      val name: String
      val age: Int
    }

    class Cat(val name: String, val age: Int) extends Pet
    class Dog(val name: String, val age: Int) extends Pet

    val dog = new Dog("Harry", 10)
    val cat = new Cat("Sally", 20)

    val animals = ArrayBuffer.empty[Pet]
    animals.append(dog)
    animals.append(cat)
  }


  @Test
  def polymorphismAndCaseClasses(): Unit = {

    // Defines fields common to all locations
    trait Location {
      val key: Long

      val id: String
      val name: String
      val locType: String
    }

    // Fields common to all locations that have parent.
    trait ChildLocation extends Location {
      val parentKey: Long
      val seasonId: Long
    }

    // home site
    case class HomeSite(key: Long, id: String, name: String, locType: String) extends Location

    // environment
    case class Site(key: Long, parentKey: Long, seasonId: Long, id: String, name: String, locType: String) extends ChildLocation
    case class Plant(key: Long, id: String, name: String, locType: String) extends Location

    // sub environment
    case class SubSite(key: Long, parentKey: Long, seasonId: Long, id: String, name: String, locType: String, crewsId: String) extends ChildLocation
    case class ProductionField(key: Long, parentKey: Long, seasonId: Long, id: String, name: String, locType: String) extends ChildLocation

    val ss = SubSite(1000, 100, 9855L, "id", "name", "subsite", "100")

    val parentKey = if (ss.isInstanceOf[ChildLocation]) Some(100) else None

  }

}
