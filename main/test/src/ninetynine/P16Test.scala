package ninetynine

class P16Test extends munit.ScalaCheckSuite:

  test("P16 - drop") {
    val result = P16.drop(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    val expected = List('a', 'b', 'd', 'e', 'g', 'h', 'j', 'k')
    assertEquals(result, expected)
  }

end P16Test
