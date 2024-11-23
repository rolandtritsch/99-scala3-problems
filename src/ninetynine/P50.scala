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
  }

  /** Leaf node representing a character with its frequency */
  case class LeafNode(char: Char, frequency: Int) extends HuffmanNode

  /** Internal node representing a branch in the Huffman tree */
  case class InternalNode(left: HuffmanNode, right: HuffmanNode, frequency: Int) extends HuffmanNode

  /** Build a Huffman tree from character frequencies
    *
    * @param frequencies Map of characters and their frequencies
    * @return Root node of the Huffman tree
    */
  def buildHuffmanTree(frequencies: Map[Char, Int]): HuffmanNode = {
    logger.debug(s"Building Huffman tree for frequencies: $frequencies")
    
    // Convert frequencies to leaf nodes
    def buildTree(nodes: List[HuffmanNode]): HuffmanNode = {
      if (nodes.size <= 1) nodes.head
      else {
        // Sort nodes by frequency
        val sortedNodes = nodes.sortBy(_.frequency)
        
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
    buildTree(frequencies.map { 
      case (char, freq) => LeafNode(char, freq) 
    }.toList)
  }

  /** Generate Huffman codes for characters
    *
    * @param tree Root node of the Huffman tree
    * @return Map of characters to their Huffman codes
    */
  def generateCodes(tree: HuffmanNode): Map[Char, String] = {
    logger.debug("Generating Huffman codes")
    
    def traverse(node: HuffmanNode, currentCode: String): Map[Char, String] = node match {
      case LeafNode(char, _) => Map(char -> currentCode)
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
