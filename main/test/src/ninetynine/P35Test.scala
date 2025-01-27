package ninetynine

class P35Test extends munit.ScalaCheckSuite:

  test("P35 - primeFactors"):
    assertEquals(P35.primeFactors(315), List(3, 3, 5, 7))
    assertEquals(P35.primeFactors(13), List(13))

end P35Test
