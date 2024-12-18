package com.redshiftsoft.example.scala

import com.redshiftsoft.example.scalatest.BaseSpec


/**
 * https://docs.scala-lang.org/scala3/reference/new-types/intersection-types.html
 */
class Types_Intersect_UT extends BaseSpec:

  trait Resettable:
    def reset(): Unit

  trait Growable[T]:
    def add(t: T): Unit

  class Foo[T] extends Resettable, Growable[T]:
    override def reset(): Unit = None

    override def add(t: T): Unit = None

  def function(x: Resettable & Growable[String]): Unit =
    x.reset()
    x.add("first")

  "foo instances" should "be valid arguments to function" in:
    // then
    val o1 = new Foo[String]

    // then
    function(o1)

