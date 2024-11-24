package ninetynine

import org.scalacheck.Prop._

class P07Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  property("P07 - nested") {
    assert(P07.flatten(List(List(1, 2), 3)) == List(1, 2, 3))
    assert(P07.flatten(List(List(1, 2), List(3, 4))) == List(1, 2, 3, 4))
    assert(P07.flatten(List(List(1, List(2)), List(3, 4))) == List(1, 2, 3, 4))
    assert(
      P07.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) == List(1, 1, 2, 3,
        5, 8)
    )

    forAll { (l: List[List[Int]]) =>
      P07.flatten(l) == l.flatten
    }
  }

}
