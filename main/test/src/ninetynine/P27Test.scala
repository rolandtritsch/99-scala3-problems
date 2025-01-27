package ninetynine

class P27Test extends munit.ScalaCheckSuite:

  test("P27 - group3"):
    val input = List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")
    val result = P27.group3(input)

    assert(result.length > 0)
    result.foreach: groups =>
      assertEquals(groups.length, 3)
      assertEquals(groups.map(_.length).sum, input.length)
      assertEquals(groups.flatMap(_.toSet).toSet, input.toSet)

  test("P27 - group"):
    val input = List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")
    val result = P27.group(List(2, 2, 5), input)

    assert(result.length > 0)
    result.foreach: groups =>
      assertEquals(groups.length, 3)
      assertEquals(groups.map(_.length), List(2, 2, 5))
      assertEquals(groups.flatMap(_.toSet).toSet, input.toSet)

end P27Test
