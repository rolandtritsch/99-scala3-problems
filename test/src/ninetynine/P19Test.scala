package ninetynine

import org.scalacheck.Prop._

class P19Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  property("P19 - rotate") {
    val result =
      P19.rotate(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    val expected = List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'a', 'b', 'c')
    assertEquals(result, expected)

    forAll { (n: Int, l: List[Int]) =>
      (n >= 0 && l.size - 1 > n) ==> (P19.rotate(n, l) == {
        if (n >= 0) l.drop(n) ++ l.take(n)
        else l.drop(n + l.size) ++ l.take(n + l.size)
      })
    }
  }

}
