package ninetynine

/** P50 - Huffman code. Given a list of symbols with their frequencies, 
  * construct a list of the symbols with their Huffman codes.
  */

object P50 {
  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return the set of codes (for the given string). */
  def huffman(str: String): Set[(Char, String)] = {
    val freqs = P09.pack(str.toList).map(groupedChars => (groupedChars.head, groupedChars.length)).toSet
    huffman(freqs)
  }

  /** @return the set of codes (for the given frequencies). */
  def huffman[A: Ordering](freqs: Set[(A, Int)]): Set[(A, String)] = {
    require(freqs.forall(_._2 > 0), "freqs.forall(_._2 > 0)")
    require(freqs.map(_._1).size == freqs.size, "freqs.map(_._1).size == freqs.size")
    logger.debug(s"${freqs}")
    
    case class Node[A](freq: Int, maxValue: A, value: Option[A], left: Option[Node[A]], right: Option[Node[A]])

    /** @return the rootNode of the tree (for the given list of nodes) */
    def buildTree[A: Ordering](nodes: List[Node[A]]): Node[A] = nodes match {
      case n :: Nil => n
      case _ => 
        val sorted = nodes.sortBy(n => (n.freq, n.maxValue))
        val (left, right) = (sorted(0), sorted(1))
        buildTree(Node(left.freq + right.freq, left.maxValue, None, Some(left), Some(right)) :: sorted.tail.tail)
    }

    /** @return the list of all codes (for the given tree). */
    def buildCodes[A](node: Node[A], code: String): List[(A, String)] = 
      (node.value, node.left, node.right) match {
        case (Some(v), _, _) => List((v, code))
        case (None, Some(l), Some(r)) => 
          buildCodes(l, "0" + code) ::: buildCodes(r, "1" + code)
        case _ => Nil
      }

    if (freqs.isEmpty) Set()
    else {
      val initialNodes = freqs.map { (value, frequency) => Node(frequency, value, Some(value), None, None) }
      val rootNode = buildTree(initialNodes.toList)
      buildCodes(rootNode, "").toSet
    }
  }
}