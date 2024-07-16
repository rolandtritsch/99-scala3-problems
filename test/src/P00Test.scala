package ninetynine

import org.scalacheck.Prop._

class P00Test extends munit.ScalaCheckSuite {
  property("P01") {
    forAll { (l: List[Int]) =>
      l.nonEmpty ==> (P01.last(l) == l.last)
    }
  }
}
