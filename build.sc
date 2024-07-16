import mill._
import mill.scalalib._
import mill.scalalib.scalafmt._

object ninetynine extends RootModule with ScalaModule with ScalafmtModule {
  def scalaVersion = "3.4.2"
  def ivyDeps = Agg(
    ivy"com.typesafe.scala-logging::scala-logging:3.9.5",
    ivy"ch.qos.logback:logback-classic:1.3.5"
  )
  
  object test extends ScalaTests with TestModule.Munit {
    def ivyDeps = Agg(
      ivy"org.scalameta::munit::1.0.0",
      ivy"org.scalameta::munit-scalacheck:1.0.0"
    )
  }
}
