package ninetynine


class P36Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P36 - primeFactorMultiplicity") {
    assertEquals(
      P36.primeFactorMultiplicity(-315),
      List((3, 2), (5, 1), (7, 1))
    )
    assertEquals(P36.primeFactorMultiplicity(315), List((3, 2), (5, 1), (7, 1)))
    assertEquals(P36.primeFactorMultiplicity(100), List((2, 2), (5, 2)))
    assertEquals(P36.primeFactorMultiplicity(17), List((17, 1)))
    assertEquals(P36.primeFactorMultiplicity(1), List())
    assertEquals(P36.primeFactorMultiplicity(0), List())

    import spire.math._
    import spire.math.SafeLong._

    (-999 to 999).foreach { n =>
      val result = P36.primeFactorMultiplicity(n)
      val expected = n.factor.map((p, e) => (p.toInt, e)).toList.sorted
      assertEquals(result, expected)
    }
  }

}
