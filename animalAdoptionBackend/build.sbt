name := """animalAdoption"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.10"


libraryDependencies ++= Seq(
  guice,
  evolutions,

  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
  "mysql" % "mysql-connector-java" % "8.0.28",
  "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
  "com.pauldijou" %% "jwt-play" % "5.0.0",
  "com.pauldijou" %% "jwt-core" % "5.0.0",
  "org.mindrot"  % "jbcrypt"   % "0.3m",
  "com.typesafe.play" %% "play-mailer" % "8.0.1",
  "com.typesafe.play" %% "play-mailer-guice" % "8.0.1",
  "com.vonage" % "client" % "6.2.0",
  "com.nexmo" % "client" % "5.6.0"
)

