package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class String_UT {

  @Test def constructor(): Unit = {
    val string1 = new String("this is a string")
  }

  @Test(expected = classOf[NullPointerException]) def constructorNull(): Unit = {
    new String(null, "UTF-8")
  }

  @Test def multiLineStrings() {
    val multiLineString =
      """
        stuff
        and more stuff
      """.stripMargin

    Assert.assertEquals("        stuff        and more stuff      ", multiLineString.replace("\n", ""))
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