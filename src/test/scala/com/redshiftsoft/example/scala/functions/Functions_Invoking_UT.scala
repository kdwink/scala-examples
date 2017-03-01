package com.redshiftsoft.example.scala.functions

import org.junit.{Assert, Test}

class Functions_Invoking_UT {

  @Test def invokeWithOperatorNotation(): Unit = {
    Assert.assertEquals("eith", "Keith" substring 1)
    Assert.assertEquals("ei", "Keith" substring(1, 3))
  }

  @Test def withAndWithoutParenthesis(): Unit = {
    def accessDBFunc(): Int = 20

    Assert.assertEquals(20, accessDBFunc)
    Assert.assertEquals(20, accessDBFunc())
  }

}