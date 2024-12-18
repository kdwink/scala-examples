ThisBuild / scalaVersion := "3.6.2"
ThisBuild / organization := "com.redshiftsoft"

lazy val scalaProject = (project in file("."))
  .settings(
    name := "scala",

    scalacOptions ++= Seq(
      "-explain", // Explain errors in more detail.
      "--explain-types", // Explain type errors in more detail.
      "-deprecation", // Emit warning and location for usages of deprecated APIs.
      "-feature", // Emit warning and location for usages of features that should be imported explicitly.
      "-new-syntax", // Compile error if old control structure syntax is used.
      "-Xfatal-warnings", //Fail the compilation if there are any warnings.
    ),

    // https://github.com/scala/scala-parallel-collections
    libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4",
    // test
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test,
    libraryDependencies += "com.github.sbt.junit" % "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test
  )

