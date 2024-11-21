package ninetynine

/** P50 - Huffman code.
  *
  * First of all, study a good paper on Huffman coding. In this
  * problem, we will implement the so-called greedy algorithm for
  * constructing Huffman codes.
  *
  * Your task is to construct a Huffman code tree for a given set of
  * characters with their frequencies.
  *
  * Example:
  *   scala> huffman(List(('a', 45), ('b', 13), ('c', 12), ('d', 16), ('e', 9), ('f', 5)))
  *   res0: List[(Char, String)] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))
  *
  * Note: This implementation is special. It is documented that
  * huffman codes can be different for the same set of (char,
  * frequency) pairs, because there is an edge case where you need to
  * dequeue the top two nodesfrom the priority queue with the lowest
  * weight. If there are three or more nodes that have the same lowest
  * weight it depends on the order the nodes where put into the queue
  * and the internal implementation of the queue, which two of the
  * three or more nodes are the top nodes that get dequeued.
  *
  * To address this and to make the set of generated huffman codes
  * deterministc we keep track of the largest character in the subtree
  * and sort the queue by weight(descending) and maxChar(ascending).
  *
  * That way we will always get the same set of huffman codes for the
  * same set of frequencies (means huffman(text) == huffman(text.reverse),
  * which is not true for most of the implementations out there).
  */

object P50 {
  case class Node[A](value: Option[A], maxValue: A, weight: Int, left: Option[Node[A]] = None, right: Option[Node[A]] = None)

  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return the set of huffman codes for the given text. */
  def huffman(text: String): Set[(Char, String)] = {
    logger.debug(s"${text}")

    val freqs = P09.pack(text.toList).map {
      groupedChars => (groupedChars.head, groupedChars.size)
    }.toSet
    huffman(freqs)
  }

  /** @return the set of huffman codes for the given frequencies. */
  def huffman[A: Ordering](freqs: Set[(A, Int)]): Set[(A, String)] = {
    require(freqs.forall(_._2 > 0), "freqs.forall(_._2 > 0)")
    require(freqs.map(_._1).size == freqs.size, "freqs.map(_._1).size == freqs.size")
    logger.info(s"${freqs}")

    if (freqs.isEmpty) Set()
    else {
      val nodesList = freqs.map { (c, freq) => Node(Some(c), c, freq) }
      val rootNode = buildHuffmanTree(nodesList)
      buildHuffmanCodes(rootNode)
    }
  }

  /** @return the root node of the huffman tree. */
  private def buildHuffmanTree[A: Ordering](nodesInit: Set[Node[A]]): Node[A] = {
    import scala.collection.mutable

    def max[A](x: A, y: A)(implicit ord: Ordering[A]): A = {
      if (ord.gt(x, y)) x else y
    }

    def buildHuffmanTreeRec[A: Ordering](nodes: mutable.PriorityQueue[Node[A]]): Node[A] = nodes.size match {
      case 1 => nodes.head
      case _ => {
        val left = nodes.dequeue()
        val right = nodes.dequeue()
        val parent = Node(None, max(left.maxValue, right.maxValue), left.weight + right.weight, Some(left), Some(right))
        nodes.enqueue(parent)
        buildHuffmanTreeRec(nodes)
      }
    }

    val nodes = new mutable.PriorityQueue[Node[A]]()(Ordering.by {
      n => (-n.weight, n.maxValue)
    })
    nodesInit.foreach(nodes.enqueue(_))

    buildHuffmanTreeRec(nodes)
  }

  /** @return the list of huffman code for the given tree. */
  private def buildHuffmanCodes[A](rootNode: Node[A]): Set[(A, String)] = {
    def buildHuffmanCodesRec[A](node: Node[A], code: String): Set[(A, String)] = node match {
      case Node(Some(e), _, _, _, _) => Set((e, code))
      case Node(None, _, _, Some(left), Some(right)) =>
        buildHuffmanCodesRec(left, code + "0") ++ buildHuffmanCodesRec(right, code + "1")
      case _ => throw new RuntimeException("Unexpected case")
    }

    buildHuffmanCodesRec(rootNode, "")
  }
}
