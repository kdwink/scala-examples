package com.redshiftsoft.example.scala.par

import org.junit.jupiter.api.Test

import java.util.concurrent.Executors
import scala.collection.parallel.CollectionConverters.*
import scala.collection.parallel.ForkJoinTaskSupport
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}

class Parallel_Seq_Iteration_UT {

  /**
   * When using this .par property of the collections there seems to be no way to change the number of threads
   * without affecting some global state:
   *
   * https://stackoverflow.com/questions/9154691/how-to-set-the-number-of-threads-to-use-for-par
   */
  @Test def thisDoesNotWork(): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 10)

    // This has no affect.
    implicit val ec: ExecutionContextExecutor = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(1))

    array.par.foreach(i => {
      println(s"[${Thread.currentThread().getName}] got number: " + i)
      Thread.sleep(100)
    })
  }

  @Test def thisWorks(): Unit = {

    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 10).par

    array.tasksupport = new ForkJoinTaskSupport(new java.util.concurrent.ForkJoinPool(2))

    array.foreach(i => {
      println(s"[${Thread.currentThread().getName}] got number: " + i)
      Thread.sleep(100)
    })

  }

}
