package com.redshiftsoft.example.scala.classes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Class_Case_To_Map_UT {

  /**
   * Demonstrates different ways a case class can be converted to a map of key/values.
   */
  @Test
  def caseClassToMap(): Unit =

    // - - - - - - - - -
    // reflection for key and value
    // - - - - - - - - -

    case class Character1(name: String, isThief: Boolean, age: Int = 18) {

      def toStringMap: Map[String, String] = {
        this.getClass.getDeclaredFields.foldLeft(Map[String, String]()) {
          (map, field) =>
            field.setAccessible(true)
            map + (field.getName -> field.get(this).toString)
        }
      }

    }

    val c1 = Character1("testName", isThief = true, 22)
    val map1 = c1.toStringMap
    assertEquals("testName", map1("name"))
    assertEquals("true", map1("isThief"))
    assertEquals("22", map1("age"))

    // - - - - - - - - -
    // hard coded key names
    // - - - - - - - - -

    case class TheCharacter3(name: String, isThief: Boolean, age: Int) {
      def toStringMap: Map[String, String] = Map(
        "name" -> name,
        "isThief" -> isThief.toString,
        "age" -> age.toString)
    }


    val c3 = TheCharacter3("testName", isThief = true, 22)
    val map3 = c3.toStringMap
    assertEquals("testName", map3("name"))
    assertEquals("true", map3("isThief"))
    assertEquals("22", map3("age"))

}
