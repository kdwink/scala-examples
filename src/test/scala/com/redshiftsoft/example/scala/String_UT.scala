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

  @Test def interpolation(): Unit = {
    val pi = 3.14159d
    Assert.assertEquals("value is 3.14159", s"value is $pi")
    Assert.assertEquals("2pi is 6.28318", s"2pi is ${pi * 2}")
  }

  @Test def interpolationOnMultipleStrings(): Unit = {
    val pi = 3.14159d
    Assert.assertEquals("part1: 3.14159 part2: $pi", s"part1: $pi" + " part2: $pi")
  }


}
