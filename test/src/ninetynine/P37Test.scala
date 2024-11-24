package ninetynine


class P37Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P37 - totient") {
    assertEquals(P37.totient(10090), P34.totient(10090))

    P24
      .lotto(10, 1_000)
      .foreach(n => {
        assertEquals(P37.totient(n), P34.totient(n))
      })
  }

}
