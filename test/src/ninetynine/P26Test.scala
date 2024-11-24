package ninetynine


class P26Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P26 - combinations") {
    val result = P26.combinations(3, List('a', 'b', 'c', 'd', 'e'))
    assert(result.size == 60)
  }

}
