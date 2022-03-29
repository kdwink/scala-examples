package com.redshiftsoft.example.scalatest

import org.scalatest.*
import org.scalatest.flatspec.*
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.*

import scala.collection.mutable
import scala.collection.mutable.Stack


class AnyFlatSpec_ExampleSpec extends AnyFlatSpec with should.Matchers {


  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new mutable.Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }
  }


}
