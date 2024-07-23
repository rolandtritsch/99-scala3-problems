import mill._
import mill.scalalib._
import mill.scalalib.scalafmt._

import $ivy.`com.goyeau::mill-scalafix::0.4.0`
import com.goyeau.mill.scalafix.ScalafixModule

import $ivy.`com.lihaoyi::mill-contrib-scoverage:`
import mill.contrib.scoverage.ScoverageModule

object ninetynine extends RootModule with ScoverageModule with ScalafmtModule with ScalafixModule {
  def scalaVersion = "3.3.3"
  def scalacOptions = Seq("-Wunused:imports")
  def scoverageVersion = "2.1.1"

  def ivyDeps = Agg(
    ivy"com.typesafe.scala-logging::scala-logging:3.9.5",
    ivy"ch.qos.logback:logback-classic:1.3.5"
  )
  
  def scalafixIvyDeps = Agg(
    // ivy"net.pixiv::scalafix-pixiv-rule:4.5.3",
    ivy"com.github.xuwei-k::scalafix-rules:0.4.3"
  )

  object test extends ScoverageTests with TestModule.Munit {
    def testCachedArgs = Seq("--exclude-tags=ignore")
    def ivyDeps = Agg(
      ivy"org.scalameta::munit::1.0.0",
      ivy"org.scalameta::munit-scalacheck:1.0.0"
    )
  }
}
