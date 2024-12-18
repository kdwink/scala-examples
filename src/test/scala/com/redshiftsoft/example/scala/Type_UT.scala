package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Test

class Type_UT:

  @Test def tupleType(): Unit =
    type UserInfo = Tuple2[String, Int]
    val UserInfo: UserInfo = ("George", 21)

