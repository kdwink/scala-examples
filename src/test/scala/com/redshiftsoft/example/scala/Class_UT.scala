package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Class_UT {

  @Test def testClass(): Unit = {
    class User
    val u = new User
    Assert.assertTrue(u.isInstanceOf[User])
  }

  @Test def testClass2(): Unit = {
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


}
