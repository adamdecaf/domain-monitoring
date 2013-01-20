
name := "domain-monitoring"

organization := "org.decaf"

scalaVersion := "2.9.2"

libraryDependencies ++= Seq(
  "org.apache.commons" % "commons-email" % "1.2",
  "org.specs2" %% "specs2" % "1.9" % "test")

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishTo := Some("Sonatype Snapshots Nexus" at "http://nexus.nomqueue.com:8081/nexus/content/repositories/snapshots/")
