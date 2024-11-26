package ninetynine

class P19Test extends munit.ScalaCheckSuite {
  test("P19 - rotate") {
    val list = List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    assertEquals(P19.rotate(3, list), List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'a', 'b', 'c'))
    assertEquals(P19.rotate(-2, list), List('j', 'k', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'))
  }
}
