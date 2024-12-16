def helloMessage(names: Seq[String]) = names match
  case Nil =>
    "Hello!"
  case names =>
    names.mkString("Hello 1: ", ", ", "!")

println(s"Hello from Java ${System.getProperty("java.version")}")
println(helloMessage(args.toSeq))