package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class StringInterpolation_UT {

  @Test def interpolation(): Unit = {
    val pi = 3.14159d
    Assert.assertEquals("value is 3.14159", s"value is $pi")
    Assert.assertEquals("2pi is 6.28318", s"2pi is ${pi * 2}")
  }

  @Test def interpolationWithFormatting(): Unit = {
    Assert.assertEquals("value is 204,686,706", f"value is ${102343353 * 2}%,d")
    Assert.assertEquals("value is 12,792,919.13", f"value is ${102343353.0 / 8}%,.2f")
  }

  @Test def interpolationOnMultipleStrings(): Unit = {
    val pi = 3.14159d
    Assert.assertEquals("part1: 3.14159 part2: $pi", s"part1: $pi" + " part2: $pi")
  }


}