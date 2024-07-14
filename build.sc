import mill._
import mill.scalalib._

object Ninetynine extends RootModule with ScalaModule {
  def scalaVersion = "3.4.2"
  
  object NinetynineTests extends ScalaTests with TestModule.Munit {
    def ivyDeps = Agg(
      ivy"org.scalameta::munit::1.0.0"
    )
  }
}
