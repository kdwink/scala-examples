package com.redshiftsoft.example.scala.functions

import org.junit.{Assert, Test}

class Functions_VarArg_UT {

  @Test def varArgs(): Unit = {
    def accessDBFunc(ints: Int*): String = {
      ints.mkString(",")
    }

    Assert.assertEquals("1,2,3", accessDBFunc(1, 2, 3))
    Assert.assertEquals("1,2", accessDBFunc(1, 2))
    Assert.assertEquals("1", accessDBFunc(1))
    Assert.assertEquals("", accessDBFunc())
  }

  @Test def varArgIsImmutableSeq(): Unit = {
    def func(ints: Int*): Unit = {
      Assert.assertTrue(ints.isInstanceOf[scala.collection.immutable.Seq[Int]])
    }

    func(1, 2, 3)
  }

  @Test def passingArraysAndSeqs(): Unit = {
    def func(ints: Int*): Unit = {
      Assert.assertTrue(ints.isInstanceOf[scala.collection.immutable.Seq[Int]])
      Assert.assertEquals(ints.length, 6)
    }

    val array: Array[Int] = Array(1, 2, 3, 4, 5, 6)
    func(array: _*)

    val immutableSeq: scala.collection.immutable.Seq[Int] =
      scala.collection.immutable.Seq[Int](1, 2, 3, 4, 5, 6)
    func(immutableSeq: _*)

    val mutableSeq: scala.collection.mutable.Seq[Int] =
      scala.collection.mutable.Seq[Int](1, 2, 3, 4, 5, 6)
    func(mutableSeq.toSeq: _*)

    val seq: scala.collection.Seq[Int] =
      scala.collection.Seq[Int](1, 2, 3, 4, 5, 6)
    func(seq.toSeq: _*)


  }

}
