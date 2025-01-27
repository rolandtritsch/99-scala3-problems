package ninetynine

import org.scalacheck.Prop.*

class P50Test extends munit.ScalaCheckSuite:
  test("P50 - basic")(assertEquals(P50.huffman(Set(('a', 1))), Set(('a', ""))))

  test("P50 - same frequency"):
    val frequencies = Set(('a', 1), ('b', 1), ('c', 1), ('d', 1))
    val codes = P50.huffman(frequencies)

    assertEquals(codes.map(_._1), Set('a', 'b', 'c', 'd'))
    assert(codes.forall(_._2.length == 2), "All codes should have length 2")
    assertEquals(codes.map(_._2).size, 4, "All codes should be unique")

  test("P50 - same frequency - text"):
    val obtained = P50.huffman("abcd")
    val expected = Set(('a', "00"), ('b', "01"), ('c', "10"), ('d', "11"))

    assertEquals(obtained, expected)

  test("P50 - test THE test string"):
    val obtained = P50.huffman("this is an example of a huffman tree")
    val expected = Set(
      (' ', "111"),
      ('a', "000"),
      ('e', "001"),
      ('f', "1101"),
      ('h', "0100"),
      ('i', "0101"),
      ('l', "01100"),
      ('m', "0111"),
      ('n', "1000"),
      ('o', "01101"),
      ('p', "10010"),
      ('r', "10011"),
      ('s', "1010"),
      ('t', "1011"),
      ('u', "11000"),
      ('x', "11001"),
    )

    assertEquals(obtained, expected)

  property("P50 - reverse text gives same codes"):
    forAll: (text: String) =>
      val obtained = P50.huffman(text)
      val expected = P50.huffman(text.reverse)
      assertEquals(obtained, expected)

end P50Test
