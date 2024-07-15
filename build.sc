import mill._
import mill.scalalib._
import mill.scalalib.scalafmt._

object ninetynine extends RootModule with ScalaModule with ScalafmtModule {
  def scalaVersion = "3.4.2"
  
  object test extends ScalaTests with TestModule.Munit {
    def ivyDeps = Agg(
      ivy"org.scalameta::munit::1.0.0"
    )
  }
}
