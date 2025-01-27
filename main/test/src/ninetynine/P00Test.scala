package ninetynine

import org.scalacheck.Prop.*

class P00Test extends munit.ScalaCheckSuite:

  property("P00 - solution"):
    // TODO: Add test cases here
    val result = P00.solution()
    val expected = 0
    assertEquals(result, expected)

    // Example property-based test
    forAll((l: List[Int]) => (l.nonEmpty) ==> (P00.solution() == expected))

end P00Test
