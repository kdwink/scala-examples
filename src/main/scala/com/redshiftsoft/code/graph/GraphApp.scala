package com.redshiftsoft.code.graph

object GraphApp {

  /*
   * root --> A
   *            --> A_1
   *            --> A_2
   *              --> A_2_1
   *              --> A_2_2
   *      --> B
   *            --> B_1
   *               --> B_1_1
   *            --> B_2
   *               --> B_2_1
   */
  def main(args: Array[String]): Unit = {
    println("hello")

    val root = N("root", Seq(
      N("A", Seq(N("A_1", Seq()), N("A_2", Seq()))),
      N("B", Seq(N("B_1", Seq()), N("B_2", Seq()))))
    )

  }


}

case class N(name: String,
             s: Seq[N] = Seq());