package ninetynine

class P38Test extends munit.ScalaCheckSuite:

  test("P38 - compare totient functions"):
    val n = 10090
    val phi1 = P34.totient(n)
    val phi2 = P37.totient(n)
    
    assertEquals(phi1, phi2)

end P38Test
