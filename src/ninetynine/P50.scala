package ninetynine

/** P50 - Huffman coding
  */

object P50:
  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  case class Node[T](symbol: T, freq: Int, left: Option[Node[T]] = None, right: Option[Node[T]] = None):
    def isLeaf: Boolean = left.isEmpty && right.isEmpty

  /** @return a set of tuples containing the character and the code to represent it
    * (for the given text).
    */
  def huffman(text: String): Set[(Char, String)] =
    logger.debug(s"${text}")

    val frequencies = text.groupBy(identity).toSet.map((c, cs) => (c, cs.size))
    huffman(frequencies)

  /** @return a set of tuples containing the character and the code to represent it
    * (for the given frequencies).
    */
  def huffman[T: Ordering](frequencies: Set[(T, Int)]): Set[(T, String)] =
    logger.debug(s"${frequencies}")
    
    // Create initial nodes from frequencies
    def createNodes(freqs: Set[(T, Int)]): List[Node[T]] =
      freqs.map((symbol, freq) => Node(symbol, freq)).toList

    // Build Huffman tree by repeatedly combining the two nodes with lowest frequencies
    // (and use symbols as tie-breaker, if there are multiple nodes with the same frequency)
    def buildTree[T: Ordering](nodes: List[Node[T]]): Node[T] = nodes match
      case n :: Nil => n
      case _ =>
        val sortedNodes = nodes.sortBy(n => (n.freq, n.symbol))
        val first :: second :: remaining = sortedNodes : @unchecked
        val combined = Node(first.symbol, first.freq + second.freq, Some(first), Some(second))
        buildTree(combined :: remaining)

    // Generate codes by traversing the tree
    def generateCodes(node: Node[T], code: String = ""): Set[(T, String)] =
      if node.isLeaf then Set((node.symbol, code))
      else
        generateCodes(node.left.get, code + "0") ++ generateCodes(node.right.get, code + "1")

    frequencies.toList match
      case Nil => Set()
      case (s, _) :: Nil => Set((s, ""))
      case _ =>
        val nodes = createNodes(frequencies)
        val tree = buildTree(nodes)
        generateCodes(tree)