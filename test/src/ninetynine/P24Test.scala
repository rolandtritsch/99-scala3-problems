package ninetynine

class P24Test extends munit.ScalaCheckSuite {
  test("P24 - lotto") {
    val result = P24.lotto(6, 49)
    assertEquals(result.length, 6)
    assert(result.forall(n => n >= 1 && n <= 49))
    assertEquals(result.distinct.length, result.length)
  }
}
