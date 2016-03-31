package com.redshiftsoft.example.scala

import org.junit.Test

class TryCatch_UT {

  @Test def tryCatch(): Unit = {
    try {
      throw new NullPointerException()
    } catch {
      case e: NullPointerException =>
    }
    try {
      throw new NullPointerException("message")
    } catch {
      case e: NullPointerException =>
    }
  }

}
