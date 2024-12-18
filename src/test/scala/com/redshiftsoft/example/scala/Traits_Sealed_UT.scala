package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Test

import scala.util.Random

/**
 * A sealed trait can be extended only in the same file as its declaration.
 *
 * They are often used to provide an alternative to enums. Since they can be only extended in a single file, the
 * compiler knows every possible subtypes and can reason about it.
 */
class Traits_Sealed_UT:

  // - - - - - - - - - - - - - - - - - - - - -

  sealed trait Answer1

  case object Yes1 extends Answer1

  case object No1 extends Answer1

  // - - - - - - - - - - - - - - - - - - - - -

  trait Answer2

  case object Yes2 extends Answer2

  case object No2 extends Answer2

  // - - - - - - - - - - - - - - - - - - - - -


  @Test def sealed_trait_example(): Unit =

    val x1 = if Random.nextBoolean() then Yes1 else No1

    x1 match
      case No1 => println("No")
      case Yes1 => println("Yes")


    val x2 = if Random.nextBoolean() then Yes2 else No2

    x2 match {
      case No2 => println("No")
      case Yes2 => println("Yes")
    }