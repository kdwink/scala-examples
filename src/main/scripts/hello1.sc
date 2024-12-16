def helloMessage(names: Seq[String]) = names match
  case Nil =>
    "Hello!"
  case names =>
    names.mkString("Hello 1: ", ", ", "!")

println(helloMessage(args.toSeq))