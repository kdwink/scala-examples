ThisBuild / scalaVersion := "2.13.5"
ThisBuild / organization := "com.redshiftsoft"

lazy val hello = (project in file("."))
  .settings(
    name := "scala",

    scalacOptions ++= Seq(
      "-deprecation", // Emit warning and location for usages of deprecated APIs.
      "-feature", // Emit warning and location for usages of features that should be imported explicitly.
      "-Xmigration"
    ),

    // https://github.com/scala/scala-parallel-collections
    libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.0",
    // test
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.3" % Test,
    libraryDependencies += "junit" % "junit" % "4.13.1" % Test,
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test
  )

