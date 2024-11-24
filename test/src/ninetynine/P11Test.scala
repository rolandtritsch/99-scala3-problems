package ninetynine


class P11Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P11 - encode") {
    assert(
      P11.encode(
        List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e',
          'e')
      ) == List((4, 'a'), 'b', (2, 'c'), (2, 'a'), 'd', (4, 'e'))
    )

    assert(
      P11.encode(
        List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e',
          'e')
      ) == List((4, 'a'), 'b', (2, 'c'), (2, 'a'), 'd', (4, 'e'))
    )
  }

}
