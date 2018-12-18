name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)


libraryDependencies += "org.neo4j.driver" % "neo4j-java-driver" % "1.4.1"
libraryDependencies += "org.neo4j" % "neo4j-ogm-core" % "2.1.3"
libraryDependencies += "org.neo4j" % "neo4j-ogm-bolt-driver" % "2.1.3"
libraryDependencies += "org.neo4j" % "neo4j-ogm-http-driver" % "2.1.3"

fork in run := true
