package ninetynine

import org.scalacheck.Prop._

class P17Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  property("P17 - split") {
    val result =
      P17.split(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    val expected =
      (List('a', 'b', 'c'), List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    assertEquals(result, expected)

    forAll { (l: List[Int]) =>
      forAll { (n: Int) =>
        (l.size - 1 >= n) ==> (P17.split(n, l) == l.splitAt(n))
      }
    }
  }

}
