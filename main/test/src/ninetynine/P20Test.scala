package ninetynine

class P20Test extends munit.ScalaCheckSuite:

  test("P20 - removeAt"):
    val result = P20.removeAt(1, List('a', 'b', 'c', 'd'))
    val expected = (List('a', 'c', 'd'), 'b')
    
    assertEquals(result, expected)

end P20Test
