package ninetynine


class P49Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P49 - gray") {
    val result = P49.gray(3)
    val expected = List("000", "001", "011", "010", "110", "111", "101", "100")
    assertEquals(result, expected)
  }
  test("P49 - gray(4)") {
    val result = P49.gray(4)
    val expected = List(
      "0000",
      "0001",
      "0011",
      "0010",
      "0110",
      "0111",
      "0101",
      "0100",
      "1100",
      "1101",
      "1111",
      "1110",
      "1010",
      "1011",
      "1001",
      "1000"
    )
    assertEquals(result, expected)
  }

}
