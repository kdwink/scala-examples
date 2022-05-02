package com.redshiftsoft.example.code.graph

import com.redshiftsoft.example.scalatest.BaseSpec

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

    count(root) should be(13)
  }

  def count(n: N): Int = {
    if (n.s.isEmpty) {
      return 1
    }
    1 + n.s.map(count).sum
  }


}

case class N(name: String,
             s: Seq[N] = Seq());