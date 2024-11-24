package ninetynine


class P23Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P23 - randomSelect") {
    val result = P23.randomSelect(3, List('a', 'b', 'c', 'd', 'f', 'g', 'h'))
    assert(result.size == 3)
  }

}
