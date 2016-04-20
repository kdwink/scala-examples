package com.redshiftsoft.example.scala.collections

import org.junit.{Assert, Test}

class Stream_UT {

  @Test def bounded(): Unit = {

    def to(head: Char, end: Char): Stream[Char] = head > end match {
      case true => Stream.empty
      case false => head #:: to((head + 1).toChar, end)
    }

    Assert.assertEquals(List('a', 'b', 'c', 'd', 'e', 'f'), to('a', 'f'))
    Assert.assertEquals(List(), to('f', 'a'))
  }

  @Test def take(): Unit = {

    def inc1(i: Int): Stream[Int] = Stream.cons(i, inc1(i + 1))
    def inc2(i: Int): Stream[Int] = i #:: inc2(i + 1)

    val streamResult1 = inc1(1)
    val streamResult2 = inc1(1)

    Assert.assertEquals(List(1, 2, 3, 4, 5), streamResult1.take(5).toList)
    Assert.assertEquals(List(1, 2, 3, 4, 5), streamResult2.take(5).toList)
  }


  @Test def find(): Unit = {
    def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a + b)

    val streamResult = fibFrom(1, 1)
    Assert.assertEquals(List(1, 1, 2, 3, 5, 8, 13), streamResult.take(7).toList)

    val found: Option[Int] = streamResult.find(_ > 10)
    Assert.assertEquals(13, found.get)
  }

}