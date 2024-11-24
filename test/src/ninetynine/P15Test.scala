package ninetynine

import org.scalacheck.Prop._

class P15Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  property("P15 - duplicate") {
    val result = P15.duplicate(2, List('a', 'b', 'c', 'c', 'd'))
    val expected = List('a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'd', 'd')
    assertEquals(result, expected)

    forAll { (l: List[Int]) =>
      P15.duplicate(3, l) == l.foldLeft(List[Int]()) { (ll, e) =>
        {
          ll ++ List(e) ++ List(e) ++ List(e)
        }
      }
    }
  }

}
