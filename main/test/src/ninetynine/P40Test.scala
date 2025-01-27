package ninetynine

class P40Test extends munit.ScalaCheckSuite:

  test("P40 - goldbach"):
    assertEquals((5, 23), P40.goldbach(28))
    assertEquals((3, 7), P40.goldbach(10))
    assertEquals((3, 97), P40.goldbach(100))

end P40Test
