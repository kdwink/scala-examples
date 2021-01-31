package com.redshiftsoft.example.scala

import org.junit.Test

class Traits_Stack_UT {

  @Test def test1(): Unit = {
    val stuff = new RealStuff
    stuff.doStuff()
  }

  @Test def test2(): Unit = {
    val stuff = new RealStuff with LoggableStuff
    stuff.doStuff()
  }

  @Test def test3(): Unit = {
    val stuff = new RealStuff with LoggableStuff with TransactionalStuff
    stuff.doStuff()
  }


  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
  //
  // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

  trait Stuff {
    def doStuff(): Unit = {
      println("default stuff")
    }
  }

  trait LoggableStuff extends Stuff {
    abstract override def doStuff(): Unit = {
      println("logging enter")
      super.doStuff()
      println("logging exit")
    }
  }

  trait TransactionalStuff extends Stuff {
    abstract override def doStuff(): Unit = {
      println("start TX")
      try {
        super.doStuff()
        println("commit TX")
      } catch {
        case e: Exception =>
          println("rollback TX")
      }
    }
  }

  class RealStuff extends Stuff {
    override def doStuff(): Unit = println("doing real stuff")
  }


}
