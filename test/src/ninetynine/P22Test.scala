package ninetynine

import org.scalacheck.Prop._
import scala.util.Random

class P22Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  // property("P22 - range".tag(ignore)) {
  property("P22 - range") {
    val result = P22.range(4, 9)
    val expected = List(4, 5, 6, 7, 8, 9)
    assertEquals(result, expected)

    forAll { (f: Short) =>
      val from = f.toInt
      val to = Random.between(from, from + 100)
      P22.range(from, to) == {
        Range(from, to + 1).toList
      }
    }
  }

}
