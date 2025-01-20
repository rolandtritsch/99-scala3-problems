package ninetynine

class P39Test extends munit.ScalaCheckSuite:

  test("P39 - listPrimesInRange") {
    assertEquals(P39.listPrimesInRange(7 to 31), List(7, 11, 13, 17, 19, 23, 29, 31))
  }
