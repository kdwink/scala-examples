package com.redshiftsoft.example.code.graph

import com.redshiftsoft.example.scalatest.BaseSpec

import scala.collection.mutable

class GraphAppSpec extends BaseSpec {

  /*
   * root --> A
   *        --> A_1
   *        --> A_2
   *          --> A_2_1
   *          --> A_2_2
   *          --> A_2_3
   *      --> B
   *        --> B_1
   *          --> B_1_1
   *          --> B_1_2
   *      --> B_2
   *        --> B_2_1
   */
  "count" should "count correctly" in {
    val root: N = N("root", Seq(
      N("A", Seq(N("A_1", Seq()), N("A_2", Seq(N("A_2_1"), N("A_2_2"), N("A_2_3"))))),
      N("B", Seq(N("B_1", Seq(N("B_1_1"), N("B_1_2"))), N("B_2", Seq(N("B_2_1"))))))
    )

    count1(root) should be(13)
    count2(root) should be(13)
  }

  def count1(n: N): Int =
    1 + n.s.map(count1).sum

  /**
   * QUEUE:  enqueue -> [a, b, c] -> dequeue
   */
  def count2(n: N): Int = {
    var count = 1
    val b = mutable.ArrayDeque[N]()
    b.append(n)

    var s: N = n
    while b.nonEmpty do {
      s = b.removeHead()
      if (s.s.nonEmpty)
        b.appendAll(s.s)
      else
        count = count + 1
    }
    count
  }


}

case class N(name: String,
             s: Seq[N] = Seq());