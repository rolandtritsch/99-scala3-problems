package ninetynine

import org.scalacheck.Prop._

class P05Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  property("P05 - reverse") {
    val original = List("This", "is", "a", "test")
    val reverse = List("test", "a", "is", "This")

    assert(P05.reverse(original) == reverse)
    assert(P05.reverse(reverse) == original)

    forAll { (l: List[Int]) =>
      P05.reverse(l) == l.reverse
    }
  }

}
