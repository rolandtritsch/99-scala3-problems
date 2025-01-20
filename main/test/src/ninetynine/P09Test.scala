package ninetynine

class P09Test extends munit.ScalaCheckSuite:

  test("P09 - pack") {
    assert(
      P09.pack(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')) == List(
        List('a', 'a', 'a', 'a', 'a', 'a'),
        List('b'),
        List('c', 'c'),
        List('d'),
        List('e', 'e', 'e', 'e'),
      )
    )
    assert(P09.pack(List(3, 1, 2, 3, 2, 3)).toSet == Set(List(1), List(2, 2), List(3, 3, 3)))
  }

end P09Test
