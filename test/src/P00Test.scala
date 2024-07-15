package ninetynine

class P00Test extends munit.FunSuite {
  test("P01") {
    val result = P01.last(List(1, 2, 3))
    val expected = 3
    assertEquals(result, expected)
  }
}
