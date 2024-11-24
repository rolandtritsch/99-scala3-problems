package ninetynine

/** P50 - Huffman Coding
  *
  * Implement Huffman coding, a method for lossless data compression.
  * 
  * This implementation provides functionality to:

  * 1. Build a Huffman tree from character frequencies
  * 2. Generate Huffman codes for characters
  */
object P50 {
  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** Abstract class representing nodes in the Huffman tree */
  abstract class HuffmanNode[A] {
    def frequency: Int
    def value: A
  }

  /** Leaf node representing a value with its frequency */
  case class LeafNode[A](leafValue: A, leafFrequency: Int, thisValue: A) extends HuffmanNode[A] {
    def frequency: Int = leafFrequency
    def value: A = thisValue
  }

  /** Internal node representing a branch in the Huffman tree */
  case class InternalNode[A](left: HuffmanNode[A], right: HuffmanNode[A], internalFrequency: Int, thisValue: A) extends HuffmanNode[A] {
    def frequency: Int = internalFrequency
    def value: A = thisValue
  }

  /** @return map of Huffman codes for given string */
  def huffman(input: String): Map[Char, String] = {
    val frequencies = computeFrequencies(input)
    val tree = buildHuffmanTree(frequencies)
    generateHuffmanCodes(tree)
  }

  /** Build a Huffman tree from frequencies
    *
    * @param frequencies Map of values and their frequencies
    * @return Root node of the Huffman tree
    */
  def buildHuffmanTree[A: Ordering](frequencies: Map[A, Int]): HuffmanNode[A] = {
    require(frequencies.nonEmpty, "frequencies.nonEmpty")
    logger.debug(s"${frequencies}")

    // Helper function to get the maximum value of two values
    def maxA[A: Ordering](a: A, b: A): A = implicitly[Ordering[A]].max(a, b)
    
    def buildHuffmanTree(nodes: List[HuffmanNode[A]]): HuffmanNode[A] = nodes match {
      case Nil => throw new RuntimeException("Unexpected case")
      case node :: Nil => node
      case _ =>
        // Sort nodes by frequency first, then by value
        val sortedNodes = nodes.sortBy { n => (n.frequency, n.value) }
        
        // Take two least frequent nodes
        val first :: second :: remainingNodes = sortedNodes : @unchecked
        
        // Create a new internal node, keeping original order
        val combinedNode = InternalNode(first, second, first.frequency + second.frequency, maxA(first.value, second.value))
        
        // Recursively build the tree
        buildHuffmanTree(combinedNode :: remainingNodes)
    }

    // Convert frequencies to leaf nodes and build the tree
    val nodes = frequencies.map { (value, freq) => LeafNode(value, freq, value) }.toList

    // Special case for single character input
    nodes match {
      case n :: Nil => n
      case _ => buildHuffmanTree(nodes)
    }
  }

  /** Generate Huffman codes for values
    *
    * @param tree Root node of the Huffman tree
    * @return Map of values to their Huffman codes
    */
  def generateHuffmanCodes[A](tree: HuffmanNode[A]): Map[A, String] = {
    logger.debug(s"${tree}")
    
    def traverse(node: HuffmanNode[A], currentCode: String): Map[A, String] = node match {
      case LeafNode(value, _, _) => 
        // For single character case, return empty string as code
        if (currentCode.isEmpty) Map(value -> "")
        else Map(value -> currentCode)
      case InternalNode(left, right, _, _) => 
        // Assign '0' to the left node and '1' to the right node
        traverse(left, "0" + currentCode) ++ 
        traverse(right, "1" + currentCode)
    }
    
    traverse(tree, "")
  }

  /** Compute frequencies in a string
    *
    * @param input Input string
    * @return Map of characters and their frequencies
    */
  def computeFrequencies(input: String): Map[Char, Int] = {
    logger.debug(s"Computing frequencies for input: $input")
    input.groupBy(identity).view.mapValues(_.length).toMap
  }
}
