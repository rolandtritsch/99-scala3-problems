package ninetynine

class P55Test extends munit.ScalaCheckSuite:

  test("P55 - basic"):
    val result = P55.Tree.cBalanced(4, "x")
    assertEquals(result.size, 14)

end P55Test
