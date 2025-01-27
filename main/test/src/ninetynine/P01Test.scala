package ninetynine

import org.scalacheck.Prop.*

class P01Test extends munit.ScalaCheckSuite:

  property("P01 - last"):
    val result = P01.last(List("first", "last"))
    val expected = "last"
    assertEquals(result, expected)

    forAll((l: List[Int]) => (l.nonEmpty) ==> (P01.last(l) == l.last))

  property("P01 - last - big list"):
    // 10 string list as input
    val input = List(
      "first",
      "second",
      "third",
      "fourth",
      "fifth",
      "sixth",
      "seventh",
      "eighth",
      "ninth",
      "last",
    )
    val result = P01.last(input)
    val expected = "last"
    assertEquals(result, expected)

end P01Test
