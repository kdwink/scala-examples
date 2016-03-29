package com.redshiftsoft.example.scala

class TestUtils {

  def intercept[A](f: Unit => Unit): Unit = {
    var flag: Boolean = false
    try {
      f()
    } catch {
      case e: A =>
        flag = true
    }

    if (!flag) {
      throw new AssertionError("")
    }
  }

}
