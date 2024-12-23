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
  // Concrete types for use in the examples
  // - - - - - - - - - - - - - - - - - - - - - -

  class MyItem extends Item:
    override def productNumber: String = "i1"

  class MyBuyable extends Buyable:
    override def price: Int = 25

    override def productNumber: String = "b1"

  class MyBook extends Book:
    override def isbn: String = "b1"

    override def price: Int = 25

    override def productNumber: String = "b1"

  /**
   * In this method the type parameter of Pipeline is INVARIANT, so instances of p1 and p2 passed to oneOf must be
   * exactly Pipeline[Buyable]
   */
  @Test def example_invariant(): Unit =

    // an example of an INVARIANT type
    trait Pipeline[T]:
      def process(t: T): T

    def oneOf(p1: Pipeline[Buyable], p2: Pipeline[Buyable], b: Buyable): Buyable =
      val b1 = p1.process(b)
      val b2 = p2.process(b)
      if b1.price < b2.price then b1 else b2

    class BP extends Pipeline[Buyable]:
      def process(b: Buyable): Buyable = b

    val p1 = new BP
    val p2 = new BP
    val b = new MyBuyable
    val b1 = oneOf(p1, p2, b)
    println(b1.price)

  /**
   * In this method the type parameter of Producer is COVARIANT, so instances of p passed to makeTow must be
   * can have generic type parameter Buyable or Book
   */
  @Test def example_covariant(): Unit =

    // an example of a COVARIANT type
    trait Producer[+T]:
      def make: T

    def addItem(p: Producer[Item]): Int = 100
    def addBuyable(p: Producer[Buyable]): Int = p.make.price + p.make.price
    def addBook(p: Producer[Book]): Int = p.make.price + p.make.price

    class ItemProducer extends Producer[Item]:
      def make: Item = new MyItem()

    class BuyableProducer extends Producer[Buyable]:
      def make: Buyable = new MyBuyable()

    class BookProducer extends Producer[Book]:
      def make: Book = new MyBook()

    addItem(new ItemProducer())
    addItem(new BuyableProducer())
    addItem(new BookProducer())

    // add1(new ItemProducer()) ---- does not compile
    addBuyable(new BuyableProducer())
    addBuyable(new BookProducer())

    // addBook(new ItemProducer()) ---- does not compile
    // addBook(new BuyableProducer()) ---- does not compile
    addBook(new BookProducer());

  /**
   *
   */
  @Test def example_contravariant(): Unit =
    // an example of a CONTRAVARIANT type
    trait Consumer[-T]:
      def take(t: T): Unit

    class ItemConsumer extends Consumer[Item]:
      override def take(t: Item): Unit = None

    class BuyableConsumer extends Consumer[Buyable]:
      override def take(t: Buyable): Unit = None

    class BookConsumer extends Consumer[Book]:
      override def take(t: Book): Unit = None

    def someMethod1(c: Consumer[Item]): Unit = None

    def someMethod2(c: Consumer[Buyable]): Unit = None

    def someMethod3(c: Consumer[Book]): Unit = None

    someMethod1(new ItemConsumer())
    // someMethod1(new BookConsumer())
    // someMethod1(new BuyableConsumer())

    someMethod2(new ItemConsumer())
    someMethod2(new BuyableConsumer())
    //someMethod2(new BookConsumer())

    someMethod3(new ItemConsumer())
    someMethod3(new BuyableConsumer())
    someMethod3(new BookConsumer())