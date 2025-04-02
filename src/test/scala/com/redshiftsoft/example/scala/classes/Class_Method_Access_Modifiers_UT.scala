package com.redshiftsoft.example.scala.classes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * https://docs.scala-lang.org/scala3/book/domain-modeling-oop.html#introduction
 * https://docs.scala-lang.org/style/declarations.html#modifiers
 */
class Class_Method_Access_Modifiers_UT:

  @Test def private_methods(): Unit =
    class Example:

      private def methodOne(): String =
        "hi"

      private[classes] def methodTwo(): String =
        methodOne()

      def methodPublic(): String =
        methodTwo()

    val e = Example()
    assertEquals("hi", e.methodPublic())

