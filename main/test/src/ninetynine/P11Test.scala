package ninetynine

class P11Test extends munit.ScalaCheckSuite:

  test("P11 - encode"):
    assert(
      P11.encode(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')) ==
        List((4, 'a'), 'b', (2, 'c'), (2, 'a'), 'd', (4, 'e'))
    )

    assert(
      P11.encode(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')) ==
        List((4, 'a'), 'b', (2, 'c'), (2, 'a'), 'd', (4, 'e'))
    )

end P11Test
