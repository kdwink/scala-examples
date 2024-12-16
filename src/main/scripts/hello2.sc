#!/usr/bin/env -S scala-cli shebang


def helloMessage(names: Seq[String]) = names match
  case Nil =>
    "Hello!"
  case names =>
    names.mkString("Hello 2: ", ", ", "!")

println(helloMessage(args.toSeq))