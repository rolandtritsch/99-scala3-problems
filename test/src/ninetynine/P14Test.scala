package ninetynine

import org.scalacheck.Prop._

class P14Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  property("P14 - duplicate") {
    val result = P14.duplicate(List('a', 'b', 'c', 'c', 'd'))
    val expected = List('a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'd', 'd')
    assertEquals(result, expected)

    forAll { (l: List[Int]) =>
      P14.duplicate(l) == l.foldLeft(List[Int]()) { (ll, e) =>
        {
          ll ++ List(e) ++ List(e)
        }
      }
    }
  }

}
