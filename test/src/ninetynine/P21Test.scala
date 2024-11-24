package ninetynine


class P21Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P21 - insertAt") {
    val result = P21.insertAt('x', 1, List('a', 'b', 'c', 'd'))
    val expected = List('a', 'x', 'b', 'c', 'd')
    assertEquals(result, expected)
  }

}
