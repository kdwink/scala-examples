package com.redshiftsoft.example.scala.functions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Functions_Parameters_Implicit_UT:


  @Test def implicitParameterGroup(): Unit =

    implicit val someVal1: Int = 100

    def f(p1: Int, p2: Int)(implicit p3: Int, p4: Int) = p1 + p2 * p3 - p4

    // then -- 1 + 2 * 3 - 4
    assertEquals(3, f(1, 2)(3, 4))

    // then -- 1 + 2 * 3 - 5
    assertEquals(2, f(1, 2)(3, 5))

    // then -- the same single implicit value is used for both implicit parameters
    // 1 + 2 * 100 - 100
    assertEquals(101, f(1, 2))

  @Test def using_instead_of_implicit_means_the_using_group_MUST_be_implicit(): Unit =

    implicit val someVal1: Int = 100

    def f(p1: Int, p2: Int)(using p3: Int, p4: Int) = p1 + p2 * p3 - p4

    // then -- the same single implicit value is used for both implicit parameters
    // 1 + 2 * 100 - 100
    assertEquals(101, f(1, 2))

