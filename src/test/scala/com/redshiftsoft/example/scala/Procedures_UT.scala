package com.redshiftsoft.example.scala

import org.junit.Test

class Procedures_UT {

  @Test def declaring() = {

    def aProcedure1(x: Int): Unit = {
      println(100 +x)
    }
    def aProcedure2(x: Int) = {
      println(100 +x)
    }
    def aProcedure3(x: Int) {
      println(100 +x)
    }

    aProcedure1(10)
    aProcedure2(20)
    aProcedure3(30)

  }

}