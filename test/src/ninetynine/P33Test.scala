package ninetynine

import org.scalacheck.Prop._

class P33Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  property("P33 - coprime") {
    import spire.math._

    forAll { (a: Int, b: Int) =>
      assertEquals(P33.isCoprimeTo(a, b), gcd(a, b).toInt == 1)
    }
  }

}
