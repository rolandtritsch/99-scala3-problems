package ninetynine

class P18Test extends munit.ScalaCheckSuite:

  test("P18 - slice"):
    val result = P18.slice(3, 7, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    val expected = List('d', 'e', 'f', 'g')

    assertEquals(result, expected)

end P18Test
