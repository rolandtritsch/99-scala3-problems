package ninetynine

class P28Test extends munit.ScalaCheckSuite {
  test("P28 - lsort") {
    val input = List(List('a', 'b', 'c'), List('d', 'e'), List('f', 'g', 'h'), List('d', 'e'), List('i', 'j', 'k', 'l'), List('m', 'n'), List('o'))
    val expected = List(List('o'), List('d', 'e'), List('d', 'e'), List('m', 'n'), List('a', 'b', 'c'), List('f', 'g', 'h'), List('i', 'j', 'k', 'l'))
    assertEquals(P28.lsort(input), expected)
  }

  test("P28 - lsortFreq - Char") {
    val input = List(
      List('a', 'b', 'c'),
      List('d', 'e'),
      List('f', 'g', 'h'),
      List('d', 'e'),
      List('i', 'j', 'k', 'l'),
      List('m', 'n'),
      List('o')
    )
    val expected = List(
      List('i', 'j', 'k', 'l'),
      List('o'),
      List('a', 'b', 'c'),
      List('f', 'g', 'h'),
      List('d', 'e'),
      List('d', 'e'),
      List('m', 'n')
    )
    assertEquals(P28.lsortFreq(input), expected)
  }
}
