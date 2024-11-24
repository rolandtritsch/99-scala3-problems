package ninetynine


class P27Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P27 - group3") {
    val result = P27.group3(
      List(
        "Aldo",
        "Beat",
        "Carla",
        "David",
        "Evi",
        "Flip",
        "Gary",
        "Hugo",
        "Ida"
      )
    )
    assert(result.flatten.flatten.flatten.size == 18144)
  }
  test("P27 - group") {
    val result = P27.group(
      List(2, 2, 5),
      List(
        "Aldo",
        "Beat",
        "Carla",
        "David",
        "Evi",
        "Flip",
        "Gary",
        "Hugo",
        "Ida"
      )
    )
    assert(result.flatten.flatten.flatten.size == 13063680)
  }

}
