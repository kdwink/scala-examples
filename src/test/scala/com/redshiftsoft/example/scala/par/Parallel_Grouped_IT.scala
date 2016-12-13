package com.redshiftsoft.example.scala.par

import org.junit.{Assert, Test}

class Parallel_Grouped_IT {

  @Test def test(): Unit = {

    val list = 1 to 9999

    val Size = list.length
    val GroupSize = if (Size > 1000) Size / 3 + 1 else Size

    println(s"Size     : $Size")
    println(s"GroupSize: $GroupSize")

    list.grouped(GroupSize).toSeq.par.flatMap(subList => {
      printf(s"[${Thread.currentThread().getId}] sublist: ${subList.length} \n")
      //Thread.sleep(10*1000)
      subList.slice(0, 10)
    })

    Assert.assertFalse(false)
  }

}
