package com.redshiftsoft.example.scala

import com.redshiftsoft.example.scalatest.BaseSpec

class Enumerations_Scala3_UT extends BaseSpec {

  "enumerations" should "be easy" in {

    enum Color:
      case Red, Green, Blue

  }

  "enumerations" should "be parameratized" in {
    enum Color(val rgb: Int):
      case Red extends Color(0xFF0000)
      case Green extends Color(0x00FF00)
      case Blue extends Color(0x0000FF)
  }

  "enumeration" should "have valueOf" in {
    enum Color:
      case Red, Green, Blue

    // works
    val x1 = Color.valueOf("Red")
    x1 should be(Color.Red)

    // case sensitive
    val t = intercept[IllegalArgumentException](Color.valueOf("RED"))
    t.getMessage should be("enum case not found: RED")

  }

}
