package ninetynine

class P22Test extends munit.ScalaCheckSuite {
  test("P22 - range") {
    assertEquals(P22.range(4, 9), List(4, 5, 6, 7, 8, 9))
  }
}
