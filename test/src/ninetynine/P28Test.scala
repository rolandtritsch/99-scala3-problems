package ninetynine


class P28Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P28 - lsort") {
    val input = List(
      List('a', 'b', 'c'),
      List('d', 'e'),
      List('f', 'g', 'h'),
      List('d', 'e'),
      List('i', 'j', 'k', 'l'),
      List('m', 'n'),
      List('o')
    )
    val result = P28.lsort(input)
    val expected = List(
      List('o'),
      List('d', 'e'),
      List('d', 'e'),
      List('m', 'n'),
      List('a', 'b', 'c'),
      List('f', 'g', 'h'),
      List('i', 'j', 'k', 'l')
    )

    assertEquals(result, expected)
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
    val result = P28.lsortFreq(input)
    val expected = List(
      List('i', 'j', 'k', 'l'),
      List('o'),
      List('a', 'b', 'c'),
      List('f', 'g', 'h'),
      List('d', 'e'),
      List('d', 'e'),
      List('m', 'n')
    )

    assertEquals(result, expected)
  }
  test("P28 - lsortFreq - Int") {
    val input = List(
      List(1, 2, 3),
      List(4, 5),
      List(6, 7, 8),
      List(4, 5),
      List(9, 10, 11, 12),
      List(13, 14),
      List(15)
    )
    val result = P28.lsortFreq(input)
    val expected = List(
      List(9, 10, 11, 12),
      List(15),
      List(1, 2, 3),
      List(6, 7, 8),
      List(4, 5),
      List(4, 5),
      List(13, 14)
    )

    assertEquals(result, expected)
  }

}
