package ninetynine

class P1Test extends munit.FunSuite {
  test("P1") {
    val result = P1.last(List(1, 2, 3))
    val expected = 3
    assertEquals(result, expected)
  }
}
