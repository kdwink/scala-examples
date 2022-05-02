package com.redshiftsoft.example.scala.collections.mutable

import com.redshiftsoft.example.scalatest.BaseSpec

import scala.collection.mutable

class Queue_UT extends BaseSpec {

  "dequeue" should "be fifo" in {

    val q = mutable.Queue[String]()

    q.enqueue("aa")
    q.enqueue("bb")
    q.enqueue("cc")

    q.dequeue() should be("aa")
    q.dequeue() should be("bb")
    q.dequeue() should be("cc")

  }

}
