package com.redshiftsoft.example.scala

import org.junit.Test

/**
 * While there is an Enumeration class, the scala docs here suggest the method
 * shown below.
 * https://docs.scala-lang.org/overviews/scala-book/enumerations-pizza-class.html
 */
class Enumeration_Sealed_Trait_UT {

  sealed trait Suit {
    def isRed : Boolean
    def code : String
  }
  case object Clubs extends Suit {
    override def isRed: Boolean = false
    override def code: String = "CL"
  }
  case object Spades extends Suit {
    override def isRed: Boolean = false
    override def code: String = "SP"
  }
  case object Diamonds extends Suit {
    override def isRed: Boolean = true
    override def code: String = "DI"
  }
  case object Hearts extends Suit {
    override def isRed: Boolean = true
    override def code: String = "HE"
  }

  @Test
  def thing() : Unit = {

  }


}
