package com.redshiftsoft.example.scala.par

import org.junit.jupiter.api.Assertions.{assertEquals, assertTrue}
import org.junit.jupiter.api.Test

import java.util.concurrent.Executors
import scala.collection.parallel.CollectionConverters.*
import scala.collection.parallel.mutable.ParArray
import scala.collection.parallel.{ForkJoinTaskSupport, mutable}
import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}

class Parallel_Seq_Iteration_UT:

  private val parArray: ParArray[Int] = Array(
    1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15,
    16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
    31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45,
    46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60
  ).par

  /**
   * When using this .par property of the collections there seems to be no way to change the number of threads
   * without affecting some global state:
   *
   * https://stackoverflow.com/questions/9154691/how-to-set-the-number-of-threads-to-use-for-par
   */
  @Test def par_array_does_not_use_implicit_execution_context(): Unit =

    // This has no affect.
    implicit val ec: ExecutionContextExecutor = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(2))

    // when
    val threadNames: ParArray[String] = parArray.map(_ => Thread.currentThread().getName).distinct

    // then
    assertTrue(threadNames.size > 2)

  @Test def par_array_set_thread_count(): Unit =
    // given

    parArray.tasksupport = new ForkJoinTaskSupport(new java.util.concurrent.ForkJoinPool(3))

    // when
    val threadNames: ParArray[String] = parArray.map(_ => Thread.currentThread().getName).distinct

    // then
    assertEquals("worker-1,worker-2,worker-3",
      threadNames.toList.map(s => s.replaceAll("ForkJoinPool-\\d-", "")).sorted.mkString(",")
    );


