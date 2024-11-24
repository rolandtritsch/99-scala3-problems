package ninetynine

import org.scalacheck.Prop._

class P31Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  property("P31 - isPrime") {
    import spire.math._
    import spire.math.SafeLong._

    forAll { (n: Int) =>
      (n > 1) ==> {
        assertEquals(P31.isPrime(n), n.isPrime)
      }
    }
  }

}
