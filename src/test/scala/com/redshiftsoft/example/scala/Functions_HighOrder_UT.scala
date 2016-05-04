package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Functions_HighOrder_UT {

  @Test
  def test(): Unit = {

    def stringFunc(s: String): Char = s.charAt(2)

    def safeString(s: String, f: String => Char): Char = {
      if (s == null) 'z' else f(s)
    }

    Assert.assertEquals('c', safeString("abc", stringFunc))
    Assert.assertEquals('z', safeString(null, stringFunc))

  }

}