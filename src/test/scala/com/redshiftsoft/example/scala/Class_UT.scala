package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Class_UT {

  @Test def simplest(): Unit = {
    class User
    val u = new User
    Assert.assertTrue(u.isInstanceOf[User])
  }

  @Test def constructor(): Unit = {
    class User(n: String) {
      val name: String = n

      def greet: String = s"hello from $name"

      override def toString = s"User($name)"
    }

    val u = new User("keith")

    Assert.assertTrue(u.isInstanceOf[User])
    Assert.assertEquals("keith", u.name)
    Assert.assertEquals("hello from keith", u.greet)
    Assert.assertEquals("User(keith)", u.toString)
  }

  @Test def inheritance(): Unit = {
    class A {
      def method1 = "hello 1"

      def method2 = "hello 2"
    }
    class B extends A {
      override def method2 = "hello B"
    }
    class C extends B

    val c = new C
    Assert.assertEquals("hello 1", c.method1)
    Assert.assertEquals("hello B", c.method2)
  }

  @Test def polymorphism(): Unit = {
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
    Assert.assertEquals("hello B", c1.method2)
    Assert.assertEquals("hello B", c1.method2)
    Assert.assertEquals("hello B", c1.method2)
  }

  @Test def typeParameters(): Unit = {

    class Foo[Type](element: Type) {
      def get: Type = element
    }

    val fooString = new Foo("hello")
    val fooInt = new Foo(42)

    Assert.assertEquals(42, fooInt.get)
    Assert.assertEquals("hello", fooString.get)
  }

  @Test def abstractClass(): Unit = {
    abstract class Car {
      def size: String
    }
    // Wow, implement abstract method with constructor parameter!
    class HondaFit(val year: Int, val automatic: Boolean, val size: String) extends Car {
    }

    val car = new HondaFit(2010, true, "small")
    Assert.assertEquals(2010, car.year)
    Assert.assertEquals(true, car.automatic)
    Assert.assertEquals("small", car.size)
  }

  @Test def applyMethod(): Unit = {
    class Car {
      var thing: Int = 100

      def apply(x: Int): Unit = {
        thing = x
      }
    }
    val car = new Car
    car(77)
    Assert.assertEquals(77, car.thing);

  }

}
