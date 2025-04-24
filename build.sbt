ThisBuild / scalaVersion := "2.12.20"
ThisBuild / organization := "com.redshiftsoft"

lazy val hello = (project in file("."))
  .settings(
    name := "scala",

    scalacOptions ++= Seq(
      "-deprecation", // Emit warning and location for usages of deprecated APIs.
      "-feature" // Emit warning and location for usages of features that should be imported explicitly.
    ),

    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test,
    libraryDependencies += "junit" % "junit" % "4.13.2" % Test,
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )

