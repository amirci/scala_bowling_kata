name := "bowling_kata"

version := "1.0"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.6.1" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "latest.integration",
  "org.mockito" % "mockito-all" % "1.8.5" % "test"
)