package ninetynine

class P17Test extends munit.ScalaCheckSuite {
  test("P17 - split") {
    val result = P17.split(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    val expected = (List('a', 'b', 'c'), List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    assertEquals(result, expected)
  }
}
