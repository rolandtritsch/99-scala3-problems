package ninetynine

import org.scalacheck.Prop._

class P00Test extends munit.ScalaCheckSuite {
  property("P01") {
    forAll { (l: List[Int]) =>
      l.nonEmpty ==> (P01.last(l) == l.last)
    }
  }

  property("P02") {
    forAll { (l: List[Int]) =>
      (l.size >= 2) ==> (P02.penultimate(l) == l.take(l.size - 1).last)
    }
  }
}
