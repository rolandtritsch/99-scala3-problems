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
    val codes = P50.generateCodes(tree)
    
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

    val tree = P50.buildHuffmanTree(frequencies)
    val codes = P50.generateCodes(tree)
    
    assertEquals(codes, Map.empty)
  }
  test("P50 - Huffman Coding: Single Character") {
    val input = "aaaaa"
    val frequencies = P50.computeFrequencies(input)
    val tree = P50.buildHuffmanTree(frequencies)
    val codes = P50.generateCodes(tree)
    val expectedCodes = Map('a' -> "")
    
    assertEquals(codes, expectedCodes)
  }
  test("P50 - Huffman Coding: Same Frequencies") {
    val input = "abcd"
    val frequencies = P50.computeFrequencies(input)
    val tree = P50.buildHuffmanTree(frequencies)
    val codes = P50.generateCodes(tree)
    val expectedCodes = Map('a' -> "00", 'b' -> "01", 'c' -> "10", 'd' -> "11")
    
    assertEquals(codes, expectedCodes)
  }

}
