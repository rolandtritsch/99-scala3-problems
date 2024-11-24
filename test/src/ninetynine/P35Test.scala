package ninetynine


class P35Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P35 - primeFactors") {
    assertEquals(P35.primeFactors(0), List())
    assertEquals(P35.primeFactors(1), List())
    assertEquals(P35.primeFactors(315), List(3, 3, 5, 7))
    assertEquals(P35.primeFactors(-315), List(3, 3, 5, 7))

    import spire.math._
    import spire.math.SafeLong._

    (-999 to 999).foreach { n =>
      val result = P35.primeFactors(n)
      val expected = n.factor
        .flatMap((prime, exp) => List.fill(exp)(prime.toInt))
        .toList
        .sorted
      assertEquals(result, expected)
    }
  }

}
