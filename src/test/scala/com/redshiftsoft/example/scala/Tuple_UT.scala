package com.redshiftsoft.example.scala

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test


class Tuple_UT {

  @Test def declaring(): Unit = {
    val t1 = ("keith", 100, 3.14159)
    val t2: (String, Int, Double) = ("keith", 100, 3.14159)
    val t3: (String, Int, Double) = new Tuple3[String, Int, Double]("keith", 100, 3.14159)


    for (x <- List(t1, t2, t3)) {
      assertEquals("keith", x._1)
      assertEquals(100, x._2)
      assertEquals(3.14159d, x._3, 1e-9)
    }
  }

  @Test def declaringTwoTuplesWithArrow(): Unit = {
    /* arrow operator only works for 2-tuples */
    val x = "keith" -> 2
    assertEquals("keith", x._1)
    assertEquals(2, x._2)
  }

  @Test def swap(): Unit = {
    assertEquals((2, "keith"), ("keith", 2).swap)
  }

  @Test def productArity(): Unit = {
    assertEquals(3, ("keith", 2, 3.14159).productArity)
  }

  @Test def productPrefix(): Unit = {
    assertEquals("Tuple3", ("keith", 2, 3.14159).productPrefix)
  }

  @Test def productElement(): Unit = {
    assertEquals(42, ("keith", 42, 3.14159, 'a').productElement(1))
  }

  @Test def copy(): Unit = {
    assertEquals(("keith", 42, 3.14159, 'a'), ("keith", 42, 3.14159, 'a').copy())
  }

  @Test def extending(): Unit = {
    // You can't extend, but you can define a type.

    type XX = Tuple3[String, Option[String], Option[Int]]
    type YY = (String, Option[String], Option[Int])

    val x: XX = ("string", Some("optionalString"), Some(100))
    val y: YY = ("string", Some("optionalString"), Some(100))

    assertEquals("optionalString", x._2.get)
    assertEquals("optionalString", y._2.get)
  }

  @Test def mapping(): Unit = {
    val seq: Seq[(Int, String)] = Seq((1, "one"), (2, "two"), (3, "three"))

    assertEquals("1:one|2:two|3:three", seq.map(x => s"${x._1}:${x._2}").mkString("|"))
    assertEquals("1:one|2:two|3:three", seq.map { case (x, y) => s"$x:$y" }.mkString("|"))
  }

}
