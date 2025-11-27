import sbtwelcome.*

ThisBuild / organization := "com.github.simy4"
ThisBuild / version      := "0.1.0"
ThisBuild / scalaVersion := "3.7.4"
Global / cancelable      := true

lazy val root = project
  .in(file("."))
  .settings(
    name := "everybody-codes",
    libraryDependencies ++= Seq(
      "org.scala-lang.modules" %% "scala-parallel-collections" % "1.2.0",
      "org.scalameta"          %% "munit"                      % "1.2.1" % Test
    ),
    scalacOptions ++= Seq(
      "-release",
      "21",
      "-encoding",
      "UTF-8",
      "-explain",
      "-explain-types",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-source:future-migration",
      "-preview"
    )
  )

addCommandAlias("fmt", ";scalafmtAll;scalafmtSbt")

logo :=
  raw"""                           _               _                       _
       |                          | |             | |                     | |
       |  _____   _____ _ __ _   _| |__   ___   __| |_   _    ___ ___   __| | ___  ___
       | / _ \ \ / / _ \ '__| | | | '_ \ / _ \ / _` | | | |  / __/ _ \ / _` |/ _ \/ __|
       ||  __/\ V /  __/ |  | |_| | |_) | (_) | (_| | |_| | | (_| (_) | (_| |  __/\__ \
       | \___| \_/ \___|_|   \__, |_.__/ \___/ \__,_|\__, |  \___\___/ \__,_|\___||___/
       |                      __/ |                   __/ |
       |                      |___/                   |___/
       |""".stripMargin

usefulTasks := Seq(
  UsefulTask("~compile", "Compile with file-watch enabled"),
  UsefulTask("~console", "Run REPL with file-watch enabled"),
  UsefulTask("fmt", "Run scalafmt on the entire project")
)

logoColor := scala.Console.MAGENTA
