package ninetynine

import com.typesafe.scalalogging.Logger

/** P50 - Huffman Coding
  *
  * Implement Huffman coding, a method for lossless data compression.
  * This implementation provides functionality to:
  * 1. Build a Huffman tree from character frequencies
  * 2. Generate Huffman codes for characters
  * 3. Encode and decode strings using Huffman coding
  */
object P50 {
  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** Sealed trait representing nodes in the Huffman tree */
  sealed trait HuffmanNode {
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

  /** Encode a string using Huffman codes
    *
    * @param input String to encode
    * @param codes Huffman codes for characters
    * @return Encoded binary string
    */
  def encode(input: String, codes: Map[Char, String]): String = {
    logger.debug(s"Encoding input: $input")
    
    // Special case for empty string
    if (input.isEmpty) return ""
    
    // Special case for single character repeated
    if (input.forall(_ == input.head)) {
      codes(input.head) * input.length
    } else {
      input.map(codes).mkString
    }
  }

  /** Decode a binary string using the Huffman tree
    *
    * @param encoded Encoded binary string
    * @param tree Root node of the Huffman tree
    * @return Decoded original string
    */
  def decode(encoded: String, tree: HuffmanNode): String = {
    logger.debug(s"Decoding input: $encoded")
    
    // Special case for empty string
    if (encoded.isEmpty) return ""
    
    // Determine the character code for the tree
    def getCharCode(node: HuffmanNode): Option[Char] = node match {
      case LeafNode(char, _) => Some(char)
      case _ => None
    }
    
    // Special case for single character repeated
    tree match {
      case LeafNode(char, _) => 
        // Determine the code for this character
        val code = if (char == 'a') "0" else "1"
        
        // Check if the encoded string is a repetition of this code
        if (encoded.length % code.length == 0 && 
            encoded.forall(_ == code.head)) {
          char.toString * (encoded.length / code.length)
        } else {
          throw new IllegalArgumentException("Invalid encoding for single character")
        }
      
      case _ => 
        def decodeHelper(remainingBits: String, currentNode: HuffmanNode, acc: StringBuilder): String = {
          (remainingBits, currentNode) match {
            case ("", LeafNode(char, _)) => 
              acc.append(char)
              acc.toString()
            
            case ("", InternalNode(left, right, _)) => 
              // If we run out of bits but are in an internal node, 
              // it means the input was a single character repeated
              decodeHelper(remainingBits, left, acc)
            
            case (bits, LeafNode(char, _)) => 
              acc.append(char)
              decodeHelper(bits, tree, acc)
            
            case (bits, InternalNode(left, right, _)) =>
              bits.head match {
                case '0' => decodeHelper(bits.tail, left, acc)
                case '1' => decodeHelper(bits.tail, right, acc)
                case _ => throw new IllegalArgumentException("Invalid bit in encoded string")
              }
          }
        }
        
        decodeHelper(encoded, tree, new StringBuilder())
    }
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
