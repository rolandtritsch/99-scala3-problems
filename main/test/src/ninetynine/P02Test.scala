package ninetynine

import org.scalacheck.Prop.*

class P02Test extends munit.ScalaCheckSuite:

  property("P02 - penultimate"):
    val result = P02.penultimate(List("first", "middle", "last"))
    val expected = "middle"
    assertEquals(result, expected)

    forAll: (l: List[Int]) =>
      (l.size >= 2) ==> (P02.penultimate(l) == l.take(l.size - 1).last)

end P02Test
