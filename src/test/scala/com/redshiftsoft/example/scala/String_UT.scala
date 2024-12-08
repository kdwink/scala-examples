package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertThrows, assertTrue}
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable


class String_UT {

  @Test def constructor(): Unit = {
    val string1 = new String("this is a string")
  }

  @Test def constructorNull(): Unit = {
    assertThrows(classOf[NullPointerException], () => {
      new String(null, "UTF-8")
    })
  }

  @Test def multiLineStrings(): Unit = {
    val multiLineString =
      """
        stuff
        and more stuff
      """.stripMargin

    assertEquals("        stuff        and more stuff      ", multiLineString.replace("\n", ""))
  }

  /**
   * stripMargin removes the pipe and whitespace before the pipe.
   */
  @Test def multiLineStrings_stripMargin(): Unit = {
    val x =
      """
        |line zero
        | line one
        |  line two
        |   line three""".stripMargin

    assertEquals("\nline zero\n line one\n  line two\n   line three", x)
  }

  @Test def split(): Unit = {
    val string = "one,two,  three  ,four,  five, six"
    val split: Array[String] = string.split(",").map(_.trim)
    assertEquals(6, split.length)
    assertEquals("one", split(0))
    assertEquals("two", split(1))
    assertEquals("three", split(2))
  }

}