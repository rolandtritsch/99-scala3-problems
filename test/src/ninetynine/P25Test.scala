package ninetynine

import org.scalacheck.Prop._

class P25Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  property("P25 - randomPermute") {
    val l = List('a', 'b', 'c', 'd', 'e', 'f')
    val result = P25.randomPermute(l)
    assertEquals(result.size, l.size)

    forAll { (l: List[Int]) =>
      P25.randomPermute(l).size == l.size
    }
  }

}
