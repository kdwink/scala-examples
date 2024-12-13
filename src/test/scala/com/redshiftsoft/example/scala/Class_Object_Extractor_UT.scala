package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import scala.util.Random

/**
 * https://docs.scala-lang.org/tour/extractor-objects.html
 *
 * An extractor object is an object with an unapply method. Whereas the apply method is like a constructor which takes
 * arguments and creates an object, the unapply takes an object and tries to give back the arguments.
 */
class Class_Object_Extractor_UT:


  object CustomerID:

    def apply(name: String) = s"$name-${Random.nextLong()}"

    def unapply(customerID: String): Option[String] =
      val stringArray: Array[String] = customerID.split("-")
      if stringArray.tail.nonEmpty then Some(stringArray.head) else None

  @Test def use_extractor_to_initialize_variable(): Unit =
    val customer2ID = CustomerID("Nico")
    val CustomerID(name) = customer2ID : @unchecked
    assertEquals("Nico", name)
