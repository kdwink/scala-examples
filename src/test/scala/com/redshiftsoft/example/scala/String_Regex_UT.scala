package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class String_Regex_UT {

  @Test def findFirstIn(): Unit = {
    val startsWithARegEx = "A.{3}".r

    val matchOption = startsWithARegEx.findFirstIn("bla bla A123456789")

    Assert.assertEquals("A123", matchOption.get)
  }


}