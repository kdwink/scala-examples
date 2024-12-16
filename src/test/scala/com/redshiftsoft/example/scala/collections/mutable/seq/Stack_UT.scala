package com.redshiftsoft.example.scala.collections.mutable.seq

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import scala.collection.mutable

class Stack_UT:

  @Test def stack(): Unit =
    val stack = mutable.Stack[String]()

    stack.push("e1")
    stack.push("e2")
    stack.push("e3")

    assertEquals("e3", stack.pop())
    assertEquals("e2", stack.pop())
    assertEquals("e1", stack.pop())
