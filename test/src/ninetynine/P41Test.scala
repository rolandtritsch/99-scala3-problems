package ninetynine


class P41Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P41 - goldbachList") {
    val result = P41.goldbachList(10 to 20)
    val expected = List(
      (3, 7),
      (5, 7),
      (3, 11),
      (3, 13),
      (5, 13),
      (3, 17)
    )
    assertEquals(result, expected)
  }
  test("P41 - goldbachList with no primes") {
    val result = P41.goldbachList(4 to 4)
    val expected = List((2, 2))
    assertEquals(result, expected)
  }
  test("P41 - goldbachList with invalid range") {
    intercept[IllegalArgumentException] {
      P41.goldbachList(20 to 10)
    }
  }
  test("P41 - goldbachList with negative range") {
    intercept[IllegalArgumentException] {
      P41.goldbachList(-10 to -20)
    }
  }
  test("P41 - goldbachList with single even number") {
    val result = P41.goldbachList(28 to 28)
    val expected = List((5, 23))
    assertEquals(result, expected)
  }
  test("P41 - goldbachList with large range") {
    val result = P41.goldbachList(100 to 110)
    val expected = List(
      (3, 97),
      (5, 97),
      (3, 101),
      (3, 103),
      (5, 103),
      (3, 107)
    )
    assertEquals(result, expected)
  }
  test("P41 - goldbachListLimited") {
    val result = P41.goldbachListLimited(10 to 20, 3)
    val expected = List((5, 7), (5, 13))
    assertEquals(result, expected)
  }
  test("P41 - goldbachListLimited large range") {
    val result = P41.goldbachListLimited(4 to 2000, 50)
    val expected = List(
      (73, 919),
      (61, 1321),
      (67, 1789),
      (61, 1867)
    )
    assertEquals(result, expected)
  }

}
