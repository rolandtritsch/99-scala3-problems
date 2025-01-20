package ninetynine

class P23Test extends munit.ScalaCheckSuite:

  test("P23 - randomSelect") {
    val input = List('a', 'b', 'c', 'd', 'f', 'g', 'h')
    val result = P23.randomSelect(3, input)
    assertEquals(result.length, 3)
    assert(result.forall(input.contains))
  }

end P23Test
