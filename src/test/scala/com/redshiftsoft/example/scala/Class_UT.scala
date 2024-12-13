package com.redshiftsoft.example.scala

import org.junit.*
import org.junit.jupiter.api.Assertions.{assertEquals, assertTrue}
import org.junit.jupiter.api.Test


class Class_UT {

  @Test def simplest(): Unit =
    class User
    val u = new User
    assertTrue(u.isInstanceOf[User])

  @Test def with_constructor(): Unit =
    class User(name: String, age: Int)
    val u = new User("joe", 99)
    assertTrue(u.isInstanceOf[User])

  @Test def inheritance(): Unit =
    class A:
      def method1 = "hello 1"

      def method2 = "hello 2"

    class B extends A:
      override def method2 = "hello B"

    class C extends B

    val c = new C
    assertEquals("hello 1", c.method1)
    assertEquals("hello B", c.method2)

  @Test def polymorphism(): Unit =
    class A {
      def method1 = "hello 1"

      def method2 = "hello 2"
    }
    class B extends A {
      override def method2 = "hello B"
    }
    class C extends B

    val c1: A = new C
    val c2: B = new C
    val c3: C = new C
    assertEquals("hello B", c1.method2)
    assertEquals("hello B", c1.method2)
    assertEquals("hello B", c1.method2)

  @Test def type_parameters(): Unit =

    class Foo[Type](element: Type) {
      def get: Type = element
    }

    val fooString = new Foo("hello")
    val fooInt = new Foo(42)

    assertEquals(42, fooInt.get)
    assertEquals("hello", fooString.get)

  @Test def abstract_class(): Unit =
    abstract class Car:
      def size: String

    // Wow, implement abstract method with constructor parameter!
    class HondaFit(val year: Int, val automatic: Boolean, val size: String) extends Car

    val car = new HondaFit(2010, true, "small")
    assertEquals(2010, car.year)
    assertEquals(true, car.automatic)
    assertEquals("small", car.size)

  @Test def apply_method(): Unit =
    class Car:
      var thing: Int = 100

      def apply(x: Int): Unit =
        thing = x

    val car = new Car
    car(77)
    assertEquals(77, car.thing)

  /**
   * Private members are only visible to the class/trait itself and to its companion object. Protected members are 
   * also visible to subclasses of the class.
   */
  @Test def access_modifiers(): Unit =

    class Person:
      
      // can be accessed internally only
      private var privateName = ""
      
      // can be accessed by subclass
      protected var protectedName = ""

      def name: String = privateName

      def name_=(value: String): Unit =
        privateName = value

    val john = new Person
    john.name = "John Doe"
    assertEquals("John Doe", john.name)

}
