package ninetynine

import org.scalacheck.Prop._

class P32Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  property("P32 - gcd") {
    import spire.math._

    forAll { (a: Int, b: Int) =>
      assertEquals(P32.gcd(a, b), gcd(a, b).toInt)
    }
  }

}
