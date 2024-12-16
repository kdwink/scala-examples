package com.redshiftsoft.example.scala.collections.mutable.seq

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class ListBuffer_UT {

  @Test def insert(): Unit = {
    val list = collection.mutable.ListBuffer[String]("aa", "bb", "cc")
    // when
    list.insert(0, "00")
    // then
    assertEquals("ListBuffer(00, aa, bb, cc)", list.toString())
  }

  @Test def append(): Unit = {
    val list = collection.mutable.ListBuffer[String]("aa", "bb", "cc")
    // when
    list.append("dd")
    // then
    assertEquals("ListBuffer(aa, bb, cc, dd)", list.toString())
  }

}
