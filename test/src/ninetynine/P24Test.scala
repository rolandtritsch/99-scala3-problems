package ninetynine


class P24Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P24 - lotto") {
    val result = P24.lotto(6, 49)
    assert(result.size == 6)
  }

}
