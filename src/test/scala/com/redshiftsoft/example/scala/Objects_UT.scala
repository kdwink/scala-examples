package com.redshiftsoft.example.scala

import org.junit.Test

class Objects_UT {

  @Test
  def go(): Unit = {

    object MyObject {
      val WHATEVER = 100
      var age: Int = 10
      var name: String = "george"
    }

    MyObject.age = 20
    MyObject.name = "keith"

  }

}
