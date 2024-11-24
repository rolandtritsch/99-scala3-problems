package ninetynine

import org.scalacheck.Prop._

class P16Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  property("P16 - drop") {
    val result =
      P16.drop(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    val expected = List('a', 'b', 'd', 'e', 'g', 'h', 'j', 'k')
    assertEquals(result, expected)

    forAll { (l: List[Int]) =>
      P16.drop(3, l) == l.zipWithIndex.foldLeft(List[Int]()) { (ll, e) =>
        {
          if ((e._2 + 1) % 3 == 0) ll
          else ll ++ List(e._1)
        }
      }
    }
  }

}
