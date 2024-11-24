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
  abstract class HuffmanNode[A] {
    def frequency: Int
    def value: Option[A]  // Renamed from char to value for generic type
  }

  /** Leaf node representing a value with its frequency */
  case class LeafNode[A](v: A, frequency: Int) extends HuffmanNode[A] {
    def value: Option[A] = Some(v)
  }

  /** Internal node representing a branch in the Huffman tree */
  case class InternalNode[A](left: HuffmanNode[A], right: HuffmanNode[A], frequency: Int) extends HuffmanNode[A] {
    def value: Option[A] = None
  }

  /** Build a Huffman tree from frequencies
    *
    * @param frequencies Map of values and their frequencies
    * @return Root node of the Huffman tree
    */
  def buildHuffmanTree[A: Ordering](frequencies: Map[A, Int]): HuffmanNode[A] = {
    require(frequencies.nonEmpty, "frequencies.nonEmpty")
    logger.debug(s"Building Huffman tree for frequencies: $frequencies")
    
    // Convert frequencies to leaf nodes
    def buildTree(nodes: List[HuffmanNode[A]]): HuffmanNode[A] = {
      if (nodes.size <= 1) nodes.head
      else {
        // Sort nodes by frequency first, then by ASCII value for characters
        val sortedNodes = nodes.sortBy(n => (
          n.frequency,
          n match {
            case LeafNode(v: Char, _) => v.toInt
            case LeafNode(v, _) => v.toString.hashCode
            case _ => Int.MaxValue  // Internal nodes come last
          }
        ))
        
        // Take two least frequent nodes
        val first = sortedNodes.head
        val second = sortedNodes(1)
        
        // Create a new internal node, keeping original order
        val combinedNode = InternalNode(first, second, first.frequency + second.frequency)
        
        // Recursively build the tree
        buildTree(combinedNode :: sortedNodes.drop(2))
      }
    }

    // Convert frequencies to leaf nodes and build the tree
    val nodes = frequencies.map { 
      case (value, freq) => LeafNode(value, freq) 
    }.toList

    // Special case for single character input
    nodes.size match {
      case 1 => nodes.head
      case _ => buildTree(nodes)
    }
  }

  /** Generate Huffman codes for values
    *
    * @param tree Root node of the Huffman tree
    * @return Map of values to their Huffman codes
    */
  def generateCodes[A](tree: HuffmanNode[A]): Map[A, String] = {
    logger.debug("Generating Huffman codes")
    
    def traverse(node: HuffmanNode[A], currentCode: String): Map[A, String] = node match {
      case LeafNode(value, _) => 
        // For single character case, return empty string as code
        if (currentCode.isEmpty) Map(value -> "")
        else Map(value -> currentCode)
      case InternalNode(left, right, _) => 
        // Assign '0' to the left node and '1' to the right node
        traverse(left, currentCode + "0") ++ 
        traverse(right, currentCode + "1")
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
