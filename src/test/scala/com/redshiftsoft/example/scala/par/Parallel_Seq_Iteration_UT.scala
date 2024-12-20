package com.redshiftsoft.example.scala.par

import org.junit.jupiter.api.Assertions.{assertEquals, assertTrue}
import org.junit.jupiter.api.Test

import java.util.concurrent.Executors
import scala.collection.parallel.CollectionConverters.*
import scala.collection.parallel.mutable.ParArray
import scala.collection.parallel.{ForkJoinTaskSupport, mutable}
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}

class Parallel_Seq_Iteration_UT:

  private val array: Array[Int] = Range.inclusive(0, 50_000).toArray

  /**
   * When using this .par property of the collections there seems to be no way to change the number of threads
   * without affecting some global state:
   *
   * https://stackoverflow.com/questions/9154691/how-to-set-the-number-of-threads-to-use-for-par
   */
  @Test def par_array_does_not_use_implicit_execution_context(): Unit =
    val parArray: ParArray[Int] = array.par

    // This has no affect.
    implicit val ec: ExecutionContextExecutor = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(1))

    // when
    val threadNames: ParArray[String] = parArray.map(_ => Thread.currentThread().getName).distinct

    // then
    assertTrue(threadNames.size > 1)

  @Test def par_array_set_thread_count(): Unit =
    // given
    val parArray: ParArray[Int] = array.par
    parArray.tasksupport = new ForkJoinTaskSupport(new java.util.concurrent.ForkJoinPool(3))

    // when
    val threadNames: ParArray[String] = parArray.map(_ => Thread.currentThread().getName).distinct

    // then
    assertEquals("worker-1,worker-2,worker-3",
      threadNames.toList.map(s => s.replaceAll("ForkJoinPool-\\d-", "")).sorted.mkString(",")
    );


