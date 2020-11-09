package com.redshiftsoft.example.scala.collections.immutable

import org.junit.{Assert, Test}

import scala.collection.immutable.HashSet


class HashSet_UT {

  @Test def construction(): Unit = {
    val set = HashSet(1, 10, 100, 1000, 10000)

    Assert.assertTrue(set.contains(1000))
    Assert.assertFalse(set.contains(2000))
  }

  @Test def constructionFromSeq(): Unit = {
    // given
    val seq = Seq(1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000)

    // when
    val set1 = HashSet() ++ seq
    val set2 = HashSet(seq.toArray: _*)

    // then
    Assert.assertTrue(set1.contains(1000))
    Assert.assertFalse(set1.contains(2000))
    Assert.assertTrue(set2.contains(1000))
    Assert.assertFalse(set2.contains(2000))

    Assert.assertTrue(set1.isInstanceOf[HashSet[Int]])
    Assert.assertTrue(set2.isInstanceOf[HashSet[Int]])
    Assert.assertEquals("HashTrieSet", set1.getClass.getSimpleName)
    Assert.assertEquals("HashTrieSet", set2.getClass.getSimpleName)

  }


}
