package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class String_UT {

  @Test def constructor(): Unit = {
    val string1 = new String("this is a string")
  }

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

    Assert.assertEquals("value is 204,686,706", f"value is ${102343353 * 2}%,d")
  }

  @Test def interpolationOnMultipleStrings(): Unit = {
    val pi = 3.14159d
    Assert.assertEquals("part1: 3.14159 part2: $pi", s"part1: $pi" + " part2: $pi")
  }

  @Test def split(): Unit = {
    val string = "one,two,  three  ,four,  five, six"
    val split: Array[String] = string.split(",").toStream.map(_.trim).toArray
    Assert.assertEquals(6, split.length)
    Assert.assertEquals("one", split(0))
    Assert.assertEquals("two", split(1))
    Assert.assertEquals("three", split(2))
  }

}