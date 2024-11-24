package ninetynine


class P39Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P39 - listPrimesInRange") {
    assertEquals(
      P39.listPrimesInRange(7 to 31),
      List(7, 11, 13, 17, 19, 23, 29, 31)
    )
    assertEquals(P39.listPrimesInRange(2 to 10), List(2, 3, 5, 7))
    assertEquals(P39.listPrimesInRange(2 to 1), List())
    assertEquals(P39.listPrimesInRange(2 to 2), List(2))
    assertEquals(P39.listPrimesInRange(2 to 3), List(2, 3))
    assertEquals(P39.listPrimesInRange(2 to 4), List(2, 3))
    assertEquals(P39.listPrimesInRange(2 to 5), List(2, 3, 5))
    assertEquals(P39.listPrimesInRange(2 to 6), List(2, 3, 5))
    assertEquals(P39.listPrimesInRange(2 to 7), List(2, 3, 5, 7))
    assertEquals(P39.listPrimesInRange(2 to 8), List(2, 3, 5, 7))
    assertEquals(P39.listPrimesInRange(2 to 9), List(2, 3, 5, 7))
    assertEquals(P39.listPrimesInRange(2 to 10), List(2, 3, 5, 7))
    assertEquals(P39.listPrimesInRange(2 to 11), List(2, 3, 5, 7, 11))
    assertEquals(P39.listPrimesInRange(2 to 12), List(2, 3, 5, 7, 11))
    assertEquals(P39.listPrimesInRange(2 to 13), List(2, 3, 5, 7, 11, 13))
    assertEquals(P39.listPrimesInRange(2 to 14), List(2, 3, 5, 7, 11, 13))
    assertEquals(P39.listPrimesInRange(2 to 15), List(2, 3, 5, 7, 11, 13))
    assertEquals(P39.listPrimesInRange(2 to 16), List(2, 3, 5, 7, 11, 13))
  }

}
