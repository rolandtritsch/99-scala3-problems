package ninetynine

class P37Test extends munit.ScalaCheckSuite:

  test("P37 - totient") {
    assertEquals(P37.totient(10), 4)
    assertEquals(P37.totient(315), 144)
  }

end P37Test
