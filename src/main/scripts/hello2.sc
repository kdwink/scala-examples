#!/usr/bin/env -S scala-cli shebang


def helloMessage(names: Seq[String]) = names match
  case Nil =>
    "Hello!"
  case names =>
    names.mkString("Hello 2: ", ", ", "!")



println(s"Hello from Java ${System.getProperty("java.version")}")
println(helloMessage(args.toSeq))
