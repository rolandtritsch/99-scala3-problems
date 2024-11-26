package ninetynine

import org.scalacheck.Prop._

class P08Test extends munit.ScalaCheckSuite {
  property("P08 - compress") {
    val result = P08.compress(
      List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    )
    val expected = List('a', 'b', 'c', 'd', 'e')
    assert(result.toSet == expected.toSet)

    forAll { (l: List[Int]) =>
      val ld = l.distinct
      val ll = ld ++ ld

      P08.compress(ll).toSet == l.toSet
    }
  }
}
