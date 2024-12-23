package com.redshiftsoft.example.scala.classes

import org.junit.jupiter.api.Test

/**
 * https://docs.scala-lang.org/scala3/book/types-variance.html
 */
class Class_Generic_Variance_UT:

  // - - - - - - - - - - - - - - - - - - - - - -
  // Book <: Buyable <: Item
  // - - - - - - - - - - - - - - - - - - - - - -

  trait Item:
    def productNumber: String

  trait Buyable extends Item:
    def price: Int

  trait Book extends Buyable:
    def isbn: String

  // - - - - - - - - - - - - - - - - - - - - - -
  //
  // - - - - - - - - - - - - - - - - - - - - - -

  // an example of an INVARIANT type
  trait Pipeline[T]:
    def process(t: T): T

  // an example of a COVARIANT type
  trait Producer[+T]:
    def make: T

  // an example of a CONTRAVARIANT type
  trait Consumer[-T]:
    def take(t: T): Unit

  /**
   * In this method the type parameter of Pipeline is INVARIANT, so instances of p1 and p2 passed to oneOf must be
   * exactly Pipeline[Buyable]
   */
  @Test def example_invariant(): Unit =

    def oneOf(p1: Pipeline[Buyable], p2: Pipeline[Buyable], b: Buyable): Buyable =
      val b1 = p1.process(b)
      val b2 = p2.process(b)
      if b1.price < b2.price then b1 else b2


    class BP extends Pipeline[Buyable]:
      def process(b: Buyable): Buyable = b

    class B extends Buyable:
      override def price: Int = 25

      override def productNumber: String = "b1"

    val p1 = new BP
    val p2 = new BP
    val b = new B
    val b1 = oneOf(p1, p2, b)
    println(b1.price)