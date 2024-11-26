package ninetynine

import org.scalacheck.Prop._

class P03Test extends munit.ScalaCheckSuite {
  property("P03 - nth") {
    val result = P03.nth(2, List("first", "middle", "last"))
    val expected = "last"
    assertEquals(result, expected)

    forAll { (l: List[Int]) =>
      forAll { (n: Int) =>
        (n >= 0 && l.size - 1 >= n) ==> (P03.nth(n, l) == l(n))
      }
    }
  }
}
