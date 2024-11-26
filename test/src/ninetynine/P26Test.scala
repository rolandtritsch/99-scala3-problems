package ninetynine

class P26Test extends munit.ScalaCheckSuite {
  test("P26 - combinations") {
    val input = List('a', 'b', 'c', 'd')
    val result = P26.combinations(2, input)
    val expected = List(
      List('a', 'b'),
      List('a', 'c'),
      List('a', 'd'),
      List('b', 'c'),
      List('b', 'd'),
      List('c', 'd'),
    )
    assertEquals(result.toSet, expected.toSet)
  }
}
