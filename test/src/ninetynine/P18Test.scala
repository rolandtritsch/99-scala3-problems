package ninetynine


class P18Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P18 - slice") {
    val result = P18.slice(
      3,
      7,
      List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    )
    val expected = List('d', 'e', 'f', 'g')
    assertEquals(result, expected)
  }

}
