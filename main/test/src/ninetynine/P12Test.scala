package ninetynine

import org.scalacheck.Prop.*

class P12Test extends munit.ScalaCheckSuite:

  property("P12 - decode"):
    val result = P12.decode(List((4, 'a'), (1, 'b'), (2, 'c'), (2, 'a'), (1, 'd'), (4, 'e')))
    val expected = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    assertEquals(result, expected)

    forAll: (l: List[Int]) =>
      val ld = l.distinct
      val ll = ld ++ ld

      P12.decode(P10.encode(ll)) == ll

end P12Test
