organization := "net.jazonnet.labs.kafka"
name := "sample-consumer"

scalaVersion := "2.12.4"
crossPaths := false

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka-clients" % "0.11.0.1"
)