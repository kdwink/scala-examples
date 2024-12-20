package com.redshiftsoft.example.scala.classes

import org.junit.*
import org.junit.jupiter.api.Assertions.{assertEquals, assertTrue}
import org.junit.jupiter.api.Test

class Class_Constructor_UT:

  @Test def constructor(): Unit =
    // given
    class User(n: String):
      val name: String = n

      def greet: String = s"hello from $name"

      override def toString = s"User($name)"

    // when -- invoked WITHOUT 'new' keyword.
    val u = User("keith")

    // then
    assertTrue(u.isInstanceOf[User])
    // then -- name field is public
    assertEquals("keith", u.name)
    assertEquals("hello from keith", u.greet)
    assertEquals("User(keith)", u.toString)

  @Test def constructor_private(): Unit =
    // given
    class User private(n: String):
      val name: String = n

      def this() = this("keith")

      def greet: String = s"hello from $name"

      override def toString = s"User($name)"

    // when -- invoked WITHOUT 'new' keyword.
    val u = User()

    // then
    assertEquals("keith", u.name)

  @Test def constructor_parameters_with_val_are_public_and_immutable(): Unit =
    class User(val name: String):
      def greet: String = s"hello from $name"

      override def toString = s"User($name)"


    val u = new User("keith")
    // Can't do this unless constructor arg has 'val' modifier.
    assertEquals("keith", u.name)

  @Test def constructor_parameters_with_var_are_public_and_mutable(): Unit =
    class User(var name: String):
      def greet: String = s"hello from $name"

      override def toString = s"User($name)"

    val u = new User("keith")
    u.name = "George"
    // Can't do this unless constructor arg has 'val' modifier.
    assertEquals("George", u.name)

  @Test def constructor_alternate(): Unit =
    class User(n: String):
      val name: String = n

      def this(x: String, y: String) = this(x + "-" + y)

      def this() = this("John", "Smith")

    val twoArg = new User("keith", "winkler")
    assertEquals("keith-winkler", twoArg.name)

    val noArg = new User()
    assertEquals("John-Smith", noArg.name)

  @Test def constructor_inCompanionObject(): Unit =
    class User(n: String):
      val name: String = n
    object User:
      def apply(x: String, y: String): User =
        new User(x + "==" + y)

      def apply(): User =
        User("John", "Smith")

    val twoArg = User("keith", "winkler")
    assertEquals("keith==winkler", twoArg.name)

    val noArg = User()
    assertEquals("John==Smith", noArg.name)


