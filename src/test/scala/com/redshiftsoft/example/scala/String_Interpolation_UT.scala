package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class String_Interpolation_UT {

  @Test def interpolation(): Unit = {
    val pi = 3.14159d
    Assert.assertEquals("value is 3.14159", s"value is $pi")
    Assert.assertEquals("2pi is 6.28318", s"2pi is ${pi * 2}")
  }

  @Test def interpolation_formatting_floating_point(): Unit = {
    Assert.assertEquals("value is 204,686,706", f"value is ${102343353 * 2}%,d")
    Assert.assertEquals("value is 12,792,919.13", f"value is ${102343353.0 / 8}%,.2f")
  }

  @Test def interpolation_formatting_string_padding(): Unit = {
    val s = "hi"
    Assert.assertEquals("value:        hi", f"value: $s%9s")
    Assert.assertEquals("value: hi       ", f"value: $s%-9s")
  }

  @Test def interpolation_formatting_float_padding(): Unit = {
    val d = 8.125
    Assert.assertEquals("value:     16.25", f"value: ${d * 2}%9s")
    Assert.assertEquals("value: 16.25    ", f"value: ${d * 2}%-9s")
  }


}
