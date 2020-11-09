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

  @Test def assignableToIterable(): Unit = {
    val set: Iterable[Int] = HashSet(3, 10, 100, 1000, 10000)

    Assert.assertTrue(set.forall(e => e > 2))
  }

  @Test def hashCodeInteraction(): Unit = {
    class X(name: String, value: Int)
    class Y(name: String, var value: Int) {
      override def hashCode(): Int = Integer.hashCode(value)

      override def equals(y1: Any): Boolean = y1.asInstanceOf[Y].value == this.value
    }

    // when
    val set1 = HashSet(new X("n1", 1), new X("n1", 1), new X("n1", 1))
    val set2 = HashSet(new Y("n1", 1), new Y("n1", 1), new Y("n1", 1))

    // then
    Assert.assertEquals(3, set1.size)
    Assert.assertEquals(1, set2.size)
  }

}
