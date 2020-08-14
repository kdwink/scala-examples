ThisBuild / scalaVersion := "2.12.12"
ThisBuild / organization := "com.redshiftsoft"

lazy val hello = (project in file("."))
  .settings(
    name := "scala",

    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.1" % Test,
    libraryDependencies += "junit" % "junit" % "4.13" % Test
  )

