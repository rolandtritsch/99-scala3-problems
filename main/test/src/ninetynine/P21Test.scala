package ninetynine

class P21Test extends munit.ScalaCheckSuite:

  test("P21 - insertAt"):
    val result = P21.insertAt('X', 1, List('a', 'b', 'c', 'd'))
    val expected = List('a', 'X', 'b', 'c', 'd')
    
    assertEquals(result, expected)

end P21Test
