package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

import java.lang.reflect.Constructor

class Case_Class_To_Map_UT {

  /**
   * Demonstrates different ways a case class can be converted to a map of key/values.
   */
  @Test
  def caseClassToMap(): Unit = {

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
    Assert.assertEquals("testName", map1("name"))
    Assert.assertEquals("true", map1("isThief"))
    Assert.assertEquals("22", map1("age"))

    // - - - - - - - - -
    // reflection for key, unapply for values
    // - - - - - - - - -

    case class TheCharacter2(name: String, isThief: Boolean, age: Int) {

      def toStringMap: Map[String, String] = (names zip values).toMap

      def firstConstructor: Constructor[_] = this.getClass.getConstructors.head

      def names: Array[String] = firstConstructor.getParameters.map(_.getName).filter(!_.startsWith("$"))

      def values: Seq[String] = TheCharacter2.unapply(this).get.productIterator.toSeq.map(_.toString)
    }


    val c2 = TheCharacter2("testName", isThief = true, 22)
    val map2 = c2.toStringMap
    Assert.assertEquals("testName", map2("name"))
    Assert.assertEquals("true", map2("isThief"))
    Assert.assertEquals("22", map2("age"))

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
    Assert.assertEquals("testName", map3("name"))
    Assert.assertEquals("true", map3("isThief"))
    Assert.assertEquals("22", map3("age"))

  }


}
