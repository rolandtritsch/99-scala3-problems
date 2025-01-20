package ninetynine

class P49Test extends munit.ScalaCheckSuite:

  test("P49 - gray") {
    assertEquals(P49.gray(1), List("0", "1"))
    assertEquals(P49.gray(2), List("00", "01", "11", "10"))
    assertEquals(P49.gray(3), List("000", "001", "011", "010", "110", "111", "101", "100"))
  }

end P49Test
