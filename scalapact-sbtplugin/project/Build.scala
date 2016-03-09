import sbt._
import Keys._

object Build extends sbt.Build with BuildExtra {
  lazy val sbtIdea = Project("scalapact-plugin", file("."), settings = mainSettings)




  lazy val mainSettings: Seq[Def.Setting[_]] = Seq(
    sbtPlugin := true,
    organization := "com.itv.plugins",
    name := "scalapact-plugin",
    resolvers += "ITV Repo" at " http://itvrepos.artifactoryonline.com/itvrepos/cps-libs",
    publishTo := Some("Artifactory Realm" at "https://itvrepos.artifactoryonline.com/itvrepos/cps-libs"),
    version := "0.1.2-SNAPSHOT",
    sbtVersion in Global := "0.13.11",
    scalaVersion in Global := "2.10.6",
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature"),
    libraryDependencies ++= Seq(
      "io.argonaut" %% "argonaut" % "6.1" withSources() withJavadoc(),
      "org.slf4j" % "slf4j-simple" % "1.6.4" withSources() withJavadoc(),
      "org.http4s" %% "http4s-blaze-server" % "0.11.3" withSources() withJavadoc(),
      "org.http4s" %% "http4s-dsl"          % "0.11.3" withSources() withJavadoc(),
      "org.http4s" %% "http4s-argonaut"     % "0.11.3" withSources() withJavadoc(),
      "com.itv" % "scalapact-core_2.11" % "0.1.13",
      "org.scalatest" %% "scalatest" % "2.2.6" % "test",
      "org.scalaj" %% "scalaj-http" % "2.2.1"
    )
  )
}
