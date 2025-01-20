package ninetynine

class P10Test extends munit.ScalaCheckSuite:

  test("P10 - encode") {
    assert(
      P10.encode(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')) ==
        List((4, 'a'), (1, 'b'), (2, 'c'), (2, 'a'), (1, 'd'), (4, 'e'))
    )

    assert(
      P10.encode(List('a', 'c', 'c', 'c', 'b', 'b', 'a', 'b', 'b')) ==
        List((1, 'a'), (3, 'c'), (2, 'b'), (1, 'a'), (2, 'b'))
    )
  }

end P10Test
