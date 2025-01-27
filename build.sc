import mill._
import mill.scalalib._
import mill.scalalib.scalafmt._

import $ivy.`com.goyeau::mill-scalafix::0.4.2`
import com.goyeau.mill.scalafix.ScalafixModule

import $ivy.`com.lihaoyi::mill-contrib-scoverage:`
import mill.contrib.scoverage.ScoverageModule

object main
  extends ScalaModule
  with ScoverageModule
  with ScalafmtModule
  with ScalafixModule
{
  def scalaVersion = "3.6.3"
  def scalacOptions = Seq(
    "-Wunused:imports", 
    "-Xfatal-warnings",
    "-deprecation",
    )
  def scoverageVersion = "2.2.1"

  def ivyDeps = Agg(
    ivy"com.typesafe.scala-logging::scala-logging:3.9.5",
    ivy"ch.qos.logback:logback-classic:1.3.5",
  )

  def scalafixIvyDeps = Agg(
    ivy"com.github.xuwei-k::scalafix-rules:0.5.1",
  )

  def scalafixConfig = T {
    Some(millSourcePath / ".." / ".scalafix.conf")
  }

  object test
    extends ScoverageTests
    with TestModule.Munit
    with ScalafmtModule
    with ScalafixModule
  {
    def testCachedArgs = Seq("--exclude-tags=ignore")
    def ivyDeps = Agg(
      ivy"org.scalameta::munit::1.0.0",
      ivy"org.scalameta::munit-scalacheck:1.0.0",
      ivy"org.typelevel::spire:0.18.0",
    )

    def scalafixIvyDeps = Agg(
      ivy"com.github.xuwei-k::scalafix-rules:0.5.1",
    )
    
    def scalafixConfig = T {
      Some(millSourcePath / ".." / ".." / ".scalafix.conf")
    }
  }
  object migrate extends ScalaModule {
    def scalaVersion = main.scalaVersion

    def scalacOptions = Seq(
      "-rewrite",
      "-indent",
    )

    def sources = T {
      main.sources() ++ test.sources()
    }

    def ivyDeps = T {
      main.ivyDeps() ++ test.ivyDeps()
    }
  }
}
