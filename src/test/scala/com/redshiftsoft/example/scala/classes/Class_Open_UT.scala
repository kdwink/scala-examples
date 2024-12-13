package com.redshiftsoft.example.scala.classes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Marking classes with open is a new feature of Scala 3. Having to explicitly mark classes as open avoids many common 
 * pitfalls in OO design. In particular, it requires library designers to explicitly plan for extension and for
 * instance document the classes that are marked as open with additional extension contracts.
 */
class Class_Open_UT:

  open class Person(val name: String)

  @Test
  def test(): Unit = {
    val p = Person("george")
    assertEquals("george", p.name)
  }
