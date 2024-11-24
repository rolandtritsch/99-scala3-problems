package ninetynine


class P40Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P40 - goldbach") {
    assertEquals(P40.goldbach(28), (5, 23))
    assertEquals(P40.goldbach(10), (3, 7))
    assertEquals(P40.goldbach(100), (3, 97))
    assertEquals(P40.goldbach(8), (3, 5))
    assertEquals(P40.goldbach(36), (5, 31))
    assertEquals(P40.goldbach(92), (3, 89))
    assertEquals(P40.goldbach(1000000), (17, 999983))
    assertEquals(P40.goldbach(1048590), (7, 1048583))

    intercept[IllegalArgumentException](P40.goldbach(2))
    intercept[IllegalArgumentException](P40.goldbach(3))
    intercept[IllegalArgumentException](P40.goldbach(-4))
  }
}
