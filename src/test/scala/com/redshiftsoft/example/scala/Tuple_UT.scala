package com.redshiftsoft.example.scala

import org.junit.{Assert, Test}

class Tuple_UT {

  @Test def declaring(): Unit = {
    val t1 = ("keith", 100, 3.14159)
    val t2: (String, Int, Double) = ("keith", 100, 3.14159)
    val t3: (String, Int, Double) = new Tuple3[String, Int, Double]("keith", 100, 3.14159)


    for (x <- List(t1, t2, t3)) {
      Assert.assertEquals("keith", x._1)
      Assert.assertEquals(100, x._2)
      Assert.assertEquals(3.14159d, x._3, 1e-9)
    }
  }

  @Test def declaringTwoTuplesWithArrow(): Unit = {
    /* arrow operator only works for 2-tuples */
    val x = "keith" -> 2
    Assert.assertEquals("keith", x._1)
    Assert.assertEquals(2, x._2)
  }

  @Test def swap(): Unit = {
    Assert.assertEquals((2, "keith"), ("keith", 2).swap)
  }

  @Test def productArity(): Unit = {
    Assert.assertEquals(3, ("keith", 2, 3.14159).productArity)
  }

  @Test def productPrefix(): Unit = {
    Assert.assertEquals("Tuple3", ("keith", 2, 3.14159).productPrefix)
  }

  @Test def productElement(): Unit = {
    Assert.assertEquals(42, ("keith", 42, 3.14159, 'a').productElement(1))
  }

  @Test def copy(): Unit = {
    Assert.assertEquals(("keith", 42, 3.14159, 'a'), ("keith", 42, 3.14159, 'a').copy())
  }

  @Test def extending(): Unit = {
    // You can't extend, but you can define a type.

    type XX = Tuple3[String, Option[String], Option[Int]]
    type YY = (String, Option[String], Option[Int])

    val x: XX = ("string", Some("optionalString"), Some(100))
    val y: YY = ("string", Some("optionalString"), Some(100))

    Assert.assertEquals("optionalString", x._2.get)
    Assert.assertEquals("optionalString", y._2.get)
  }

  @Test def mapping(): Unit = {
    val seq: Seq[(Int, String)] = Seq((1, "one"), (2, "two"), (3, "three"))

    Assert.assertEquals("1:one|2:two|3:three", seq.map(x => s"${x._1}:${x._2}").mkString("|"))
    Assert.assertEquals("1:one|2:two|3:three", seq.map { case (x, y) => s"$x:$y" }.mkString("|"))
  }

}
