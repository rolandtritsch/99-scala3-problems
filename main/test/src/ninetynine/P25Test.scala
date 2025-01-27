package ninetynine

class P25Test extends munit.ScalaCheckSuite:

  test("P25 - randomPermute"):
    val input = List('a', 'b', 'c', 'd', 'e', 'f')
    val result = P25.randomPermute(input)
    
    assertEquals(result.length, input.length)
    assertEquals(result.toSet, input.toSet)

end P25Test
