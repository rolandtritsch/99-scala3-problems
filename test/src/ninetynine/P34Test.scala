package ninetynine


class P34Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P34 - totient") {
    assertEquals(P34.totient(0), 0)
    assertEquals(P34.totient(1), 1)
    assertEquals(P34.totient(7), 6)
    assertEquals(P34.totient(10), 4)
    assertEquals(P34.totient(9), 6)
    assertEquals(P34.totient(10090), 4032)

    intercept[IllegalArgumentException](P34.totient(-1))
  }

}
