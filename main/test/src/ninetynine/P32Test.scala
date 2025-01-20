package ninetynine

class P32Test extends munit.ScalaCheckSuite:

  test("P32 - gcd") {
    assertEquals(P32.gcd(36, 63), 9)
    assertEquals(P32.gcd(49, 21), 7)
    assertEquals(P32.gcd(120, 48), 24)
  }

end P32Test
