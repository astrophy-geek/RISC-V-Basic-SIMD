ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.7"

val chiselVersion = "3.5.1"


lazy val root = (project in file("."))
  .settings(
    name := "simd",
    libraryDependencies ++= Seq(
      "edu.berkeley.cs" %% "chisel3"    % chiselVersion,
      "edu.berkeley.cs" %% "chiseltest" % "0.5.1" % "test",
//      "edu.berkeley.cs" %% "chisel-iotesters" % "2.5.0"

    ),
    resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
    addCompilerPlugin(
      "edu.berkeley.cs" % "chisel3-plugin" % chiselVersion cross CrossVersion.full
    )
  )

Test / logBuffered := false