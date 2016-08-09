package com.redshiftsoft.example.scala

import org.junit.Assert._
import org.junit.Test

class Class_Constructor_UT {

  @Test def constructor(): Unit = {
    class User(n: String) {
      val name: String = n

      def greet: String = s"hello from $name"

      override def toString = s"User($name)"
    }

    val u = new User("keith")

    assertTrue(u.isInstanceOf[User])
    assertEquals("keith", u.name)
    assertEquals("hello from keith", u.greet)
    assertEquals("User(keith)", u.toString)
  }

  @Test def constructor_alternate(): Unit = {
    class User(n: String) {
      val name: String = n

      def this(x: String, y: String) = this(x + "-" + y)

      def this() = this("John", "Smith")
    }

    val twoArg = new User("keith", "winkler")
    assertEquals("keith-winkler", twoArg.name)

    val noArg = new User()
    assertEquals("John-Smith", noArg.name)
  }

  @Test def constructor_inCompanionObject(): Unit = {
    class User(n: String) {
      val name: String = n
    }
    object User {
      def apply(x: String, y: String): User = {
        new User(x + "==" + y)
      }

      def apply(): User = {
        User("John", "Smith")
      }
    }

    val twoArg = User("keith", "winkler")
    assertEquals("keith==winkler", twoArg.name)

    val noArg = User()
    assertEquals("John==Smith", noArg.name)
  }


}
