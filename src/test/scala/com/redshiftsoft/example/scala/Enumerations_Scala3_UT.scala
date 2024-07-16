package com.redshiftsoft.example.scala

import com.redshiftsoft.example.scalatest.BaseSpec

class Enumerations_Scala3_UT extends BaseSpec {

  "enumerations" should "be easy" in {

    enum Color:
      case Red, Green, Blue

  }

  "enumerations" should "be parameterized" in {
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
    t.getMessage.contains("has no case with name: RED") should be(true)

  }

  "enumeration" should "have members" in {
    enum Planet(mass: Double, radius: Double):
      private final val G = 6.67300E-11

      def surfaceGravity: Double = G * mass / (radius * radius)

      def surfaceWeight(otherMass: Double): Double = otherMass * surfaceGravity

      case Mercury extends Planet(3.303e+23, 2.4397e6)
      case Venus extends Planet(4.869e+24, 6.0518e6)
      case Earth extends Planet(5.976e+24, 6.37814e6)
      case Mars extends Planet(6.421e+23, 3.3972e6)
      case Jupiter extends Planet(1.9e+27, 7.1492e7)
      case Saturn extends Planet(5.688e+26, 6.0268e7)
      case Uranus extends Planet(8.686e+25, 2.5559e7)
      case Neptune extends Planet(1.024e+26, 2.4746e7)
    end Planet
  }

}
