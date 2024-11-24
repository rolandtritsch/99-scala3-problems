package ninetynine


class P50Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  test("P50 - Huffman Coding: Compute Frequencies") {
    val input = "hello world"
    val frequencies = P50.computeFrequencies(input)
    
    assertEquals(frequencies('h'), 1)
    assertEquals(frequencies('e'), 1)
    assertEquals(frequencies('l'), 3)
    assertEquals(frequencies('o'), 2)
    assertEquals(frequencies(' '), 1)
    assertEquals(frequencies('w'), 1)
    assertEquals(frequencies('r'), 1)
    assertEquals(frequencies('d'), 1)
  }
  test("P50 - Huffman Coding: Build Tree and Generate Codes") {
    val input = "hello world"
    val frequencies = P50.computeFrequencies(input)
    val tree = P50.buildHuffmanTree(frequencies)
    val codes = P50.generateHuffmanCodes(tree)
    
    assert(codes.contains('h'))
    assert(codes.contains('e'))
    assert(codes.contains('l'))
    assert(codes.contains('o'))
    assert(codes.contains(' '))
    assert(codes.contains('w'))
    assert(codes.contains('r'))
    assert(codes.contains('d'))
  }
  test("P50 - Huffman Coding: Empty String Handling") {
    val input = ""
    val frequencies = P50.computeFrequencies(input)
    
    assert(frequencies.isEmpty)
    intercept[IllegalArgumentException] {
      P50.buildHuffmanTree(frequencies)
    }
  }
  test("P50 - Huffman Coding: Single Character") {
    val input = "aaaaa"
    val frequencies = P50.computeFrequencies(input)
    val tree = P50.buildHuffmanTree(frequencies)
    val codes = P50.generateHuffmanCodes(tree)
    val expectedCodes = Map('a' -> "")
    
    assertEquals(codes, expectedCodes)
  }

  test("P50 - Huffman Coding: Same Frequencies") {
    val codes = P50.huffman("abcd")
    val expectedCodes = Map('a' -> "00", 'b' -> "10", 'c' -> "01", 'd' -> "11")
    
    assertEquals(codes, expectedCodes)
  }

  test("P50 - Huffman Coding: THE text") {
    val codes = P50.huffman("this is an example of a huffman tree")
    val expectedCodes = Map(
      'e' -> "100",
      'n' -> "1110",
      't' -> "1101",
      'a' -> "000",
      'm' -> "0110",
      'i' -> "1010",
      ' ' -> "111",
      'l' -> "00001",
      'p' -> "01001",
      'h' -> "0010",
      'r' -> "11001",
      'o' -> "10001",
      's' -> "0101",
      'x' -> "10011",
      'u' -> "00011",
      'f' -> "1011"
    )
    
    assertEquals(codes, expectedCodes)
  }
}
