package ninetynine

class P36Test extends munit.ScalaCheckSuite:

  test("P36 - primeFactorMultiplicity"):
    assertEquals(P36.primeFactorMultiplicity(315), List((3, 2), (5, 1), (7, 1)))

end P36Test
