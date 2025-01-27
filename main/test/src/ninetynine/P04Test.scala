package ninetynine

import org.scalacheck.Prop.*

class P04Test extends munit.ScalaCheckSuite:

  property("P04 - size"):
    val result = P04.size(List("first", "middle", "last"))
    val expected = 3
    assertEquals(result, expected)

    forAll: (l: List[Int]) =>
      P04.size(l) == l.size

end P04Test
