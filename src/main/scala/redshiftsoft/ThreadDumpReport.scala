package redshiftsoft

import java.nio.file.{Files, Paths}
import scala.jdk.javaapi.CollectionConverters

object ThreadDumpReport:

  def main(args: Array[String]): Unit =

    val lines = CollectionConverters.asScala(Files.readAllLines(Paths.get("thread_dump3"))).toSeq

    val threadNameMap: Map[String, Seq[Long]] =
      lines.filter(_.startsWith("\""))
        .map(line => line.replaceFirst("\"(.*?)\".*$", "$1"))
        .map(line => line.replaceFirst("(.*)[-#]\\d+$", "$1"))
        .map(line => (line, 1L))
        .groupMap(_._1)(_._2)

    // sum the occurrence of each thread name
    val countMap: Map[String, Long] = threadNameMap.map(e => (e._1, e._2.sum))

    // print entries sorted by count descending
    var cumulative = 0L
    countMap.toSeq.sortBy(_._2 * -1).foreach(e => {
      cumulative = cumulative + e._2
      println(f"$cumulative%9s ${e._2}%9s    ${e._1}")
    })

