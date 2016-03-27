package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class String_UT {


  @Test def multiLineStrings() {
    val multiLineString =
      """
        stuff
        and more stuff
      """.stripMargin


    Assert.assertEquals("        stuff        and more stuff      ", multiLineString.replace("\n", ""))
  }


}
