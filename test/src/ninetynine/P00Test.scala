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

  property("P03") {
    forAll { (n: Int, l: List[Int]) =>
      (n >= 0 && l.size - 1 >= n) ==> (P03.nth(n, l) == l(n))
    }
  }

  property("P04") {
    forAll { (l: List[Int]) =>
      P04.size(l) == l.size
    }
  }
}
