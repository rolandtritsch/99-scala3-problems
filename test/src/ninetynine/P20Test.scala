package ninetynine

import org.scalacheck.Prop._

class P20Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  property("P20 - removeAt") {
    val result = P20.removeAt(1, List('a', 'b', 'c', 'd'))
    val expected = (List('a', 'c', 'd'), 'b')
    assertEquals(result, expected)

    forAll { (n: Int, l: List[Int]) =>
      (n >= 0 && l.size - 1 >= n) ==> (P20.removeAt(n, l) == {
        (l.slice(0, n) ++ l.slice(n + 1, l.size), l(n))
      })
    }
  }

}
