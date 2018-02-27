package com.redshiftsoft.example.scala.collections.mutable

import org.junit.{Assert, Test}

import scala.collection.mutable

class Buffer_UT {

  @Test def go(): Unit = {
    val nums = collection.mutable.Buffer(1, 2, 3)
    Assert.assertEquals(3, nums.size)

    for (i <- 1 to 100) nums += i
    Assert.assertEquals(103, nums.size)
  }

  @Test def slice(): Unit = {
    val nums = collection.mutable.Buffer(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val slice1: mutable.Buffer[Int] = nums.slice(4, 7)
    Assert.assertEquals("ArrayBuffer(5, 6, 7)", slice1.toString)
  }

  @Test def append(): Unit = {
    val nums = collection.mutable.Buffer(1, 2, 3)
    nums.append(100)
    Assert.assertEquals("ArrayBuffer(1, 2, 3, 100)", nums.toString)
  }

  @Test def take(): Unit = {
    val buffer = collection.mutable.Buffer[String]("aa","bb","cc","dd","ee","ff","gg","hh")
    val slice1: mutable.Buffer[String] = buffer.take(3)
    Assert.assertEquals("ArrayBuffer(aa, bb, cc)", slice1.toString)
    Assert.assertEquals("ArrayBuffer(aa, bb, cc, dd, ee, ff, gg, hh)", buffer.toString)
  }

  @Test def drop(): Unit = {
    val buffer = collection.mutable.Buffer[String]("aa","bb","cc","dd","ee","ff","gg","hh")
    val slice1: mutable.Buffer[String] = buffer.drop(3)
    Assert.assertEquals("ArrayBuffer(dd, ee, ff, gg, hh)", slice1.toString)
    Assert.assertEquals("ArrayBuffer(aa, bb, cc, dd, ee, ff, gg, hh)", buffer.toString)
  }

  @Test def remove(): Unit = {
    val buffer = collection.mutable.Buffer[String]("aa","bb","cc","dd","ee","ff","gg","hh")
    buffer.remove(0, 3)
    Assert.assertEquals("ArrayBuffer(dd, ee, ff, gg, hh)", buffer.toString)
  }



}
