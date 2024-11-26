package ninetynine

class P13Test extends munit.ScalaCheckSuite {
  test("P13 - encode") {
    val result = P13.encode(
      List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    )
    val expected = List((6, 'a'), (1, 'b'), (2, 'c'), (1, 'd'), (4, 'e'))
    assertEquals(result, expected)
  }
}
