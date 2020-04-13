package com.redshiftsoft.example.scala.collections.mutable

import org.junit.{Assert, Test}

class ListBuffer_UT {

  @Test def insert(): Unit = {
    val list = collection.mutable.ListBuffer[String]("aa", "bb", "cc")
    // when
    list.insert(0, "00")
    // then
    Assert.assertEquals("ListBuffer(00, aa, bb, cc)", list.toString())
  }

  @Test def append(): Unit = {
    val list = collection.mutable.ListBuffer[String]("aa", "bb", "cc")
    // when
    list.append("dd")
    // then
    Assert.assertEquals("ListBuffer(aa, bb, cc, dd)", list.toString())
  }

}
