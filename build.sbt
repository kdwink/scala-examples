ThisBuild / scalaVersion := "3.4.2"
ThisBuild / organization := "com.redshiftsoft"

lazy val scalaProject = (project in file("."))
  .settings(
    name := "scala",

    scalacOptions ++= Seq(
      "-deprecation", // Emit warning and location for usages of deprecated APIs.
      "-feature", // Emit warning and location for usages of features that should be imported explicitly.
    ),

    // https://github.com/scala/scala-parallel-collections
    libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4",
    // test
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % Test,
    libraryDependencies += "junit" % "junit" % "4.13.2" % Test,
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test
  )

