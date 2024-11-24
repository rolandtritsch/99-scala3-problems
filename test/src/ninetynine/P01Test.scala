package ninetynine

import org.scalacheck.Prop._

class P01Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  property("P01 - last") {
    val result = P01.last(List("first", "last"))
    val expected = "last"
    assertEquals(result, expected)

    forAll { (l: List[Int]) =>
      (l.nonEmpty) ==> (P01.last(l) == l.last)
    }
  }

}
