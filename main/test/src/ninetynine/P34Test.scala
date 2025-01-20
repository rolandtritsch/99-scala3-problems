package ninetynine

class P34Test extends munit.ScalaCheckSuite:

  test("P34 - totient") {
    assertEquals(P34.totient(10), 4)
    assertEquals(P34.totient(1), 1)
  }

end P34Test
