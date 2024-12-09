package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import scala.util.matching.Regex


class String_Regex_UT {

  @Test def findFirstIn(): Unit = {
    // given
    val startsWithARegEx: Regex = "A.{3}".r

    // when
    val matchOption = startsWithARegEx.findFirstIn("bla bla A123456789")

    // then
    assertEquals("A123", matchOption.get)
    assertEquals("scala.util.matching.Regex", startsWithARegEx.getClass.getName)
  }


}