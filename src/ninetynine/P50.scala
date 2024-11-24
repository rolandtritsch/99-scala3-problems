package ninetynine

/** P50 - Huffman Coding
  *
  * Implement Huffman coding, a method for lossless data compression.
  * This implementation provides functionality to:
  * 1. Build a Huffman tree from character frequencies
  * 2. Generate Huffman codes for characters
  */
object P50 {
  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** Abstract class representing nodes in the Huffman tree */
  abstract class HuffmanNode {
    def frequency: Int
    def char: Option[Char]  // Added to help with sorting
  }

  /** Leaf node representing a character with its frequency */
  case class LeafNode(c: Char, frequency: Int) extends HuffmanNode {
    def char: Option[Char] = Some(c)
  }

  /** Internal node representing a branch in the Huffman tree */
  case class InternalNode(left: HuffmanNode, right: HuffmanNode, frequency: Int) extends HuffmanNode {
    def char: Option[Char] = None
  }

  /** Build a Huffman tree from character frequencies
    *
    * @param frequencies Map of characters and their frequencies
    * @return Root node of the Huffman tree
    */
  def buildHuffmanTree(frequencies: Map[Char, Int]): HuffmanNode = {
    require(frequencies.nonEmpty, "frequencies.nonEmpty")
    logger.debug(s"Building Huffman tree for frequencies: $frequencies")
    
    // Convert frequencies to leaf nodes
    def buildTree(nodes: List[HuffmanNode]): HuffmanNode = {
      if (nodes.size <= 1) nodes.head
      else {
        // Sort nodes by frequency and then by character (for consistent ordering)
        val sortedNodes = nodes.sortBy(n => (n.frequency, n.char.getOrElse(Char.MaxValue)))
        
        // Take two least frequent nodes
        val first = sortedNodes.head
        val second = sortedNodes(1)
        
        // Create a new internal node
        val combinedNode = InternalNode(first, second, first.frequency + second.frequency)
        
        // Recursively build the tree
        buildTree(combinedNode :: sortedNodes.drop(2))
      }
    }

    // Convert frequencies to leaf nodes and build the tree
    val nodes = frequencies.map { 
      case (char, freq) => LeafNode(char, freq) 
    }.toList

    // Special case for single character input
    nodes.size match {
      case 1 => nodes.head
      case _ => buildTree(nodes)
    }
  }

  /** Generate Huffman codes for characters
    *
    * @param tree Root node of the Huffman tree
    * @return Map of characters to their Huffman codes
    */
  def generateCodes(tree: HuffmanNode): Map[Char, String] = {
    logger.debug("Generating Huffman codes")
    
    def traverse(node: HuffmanNode, currentCode: String): Map[Char, String] = node match {
      case LeafNode(char, _) => 
        // For single character case, return empty string as code
        if (currentCode.isEmpty) Map(char -> "")
        else Map(char -> currentCode)
      case InternalNode(left, right, _) => 
        traverse(left, currentCode + "0") ++ 
        traverse(right, currentCode + "1")
    }
    
    traverse(tree, "")
  }

  /** Compute character frequencies in a string
    *
    * @param input Input string
    * @return Map of characters and their frequencies
    */
  def computeFrequencies(input: String): Map[Char, Int] = {
    logger.debug(s"Computing frequencies for input: $input")
    input.groupBy(identity).view.mapValues(_.length).toMap
  }
}
