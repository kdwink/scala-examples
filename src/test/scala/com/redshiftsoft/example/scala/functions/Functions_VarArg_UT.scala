package com.redshiftsoft.example.scala.functions

import org.junit.{Assert, Test}

class Functions_VarArg_UT {

  @Test def varArgs(): Unit = {
    def accessDBFunc(ints: Int*): String = {
      ints.mkString(",")
    }

    Assert.assertEquals("1,2,3", accessDBFunc(1, 2, 3))
    Assert.assertEquals("1,2", accessDBFunc(1, 2))
    Assert.assertEquals("1", accessDBFunc(1))
    Assert.assertEquals("", accessDBFunc())
  }

}
