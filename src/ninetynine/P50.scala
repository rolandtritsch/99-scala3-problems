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
  */

object P50 {
  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return the list of huffman codes. */
  def huffman[T](list: List[(T, Int)]): List[(T, String)] = {
    logger.debug(s"${list}")

    val nodesList = list.map { case (char, freq) => Node(Some(char), freq) }
    val rootNode = buildHuffmanTree(nodesList)
    buildHuffmanCodes(rootNode)
  }

  /** @return the root node of the huffman tree. */
  private def buildHuffmanTree[T](nodesList: List[Node[T]]): Node[T] = {
    import scala.collection.mutable

    def buildHuffmanTreeRec[T](nodes: mutable.PriorityQueue[Node[T]], size: Int): Node[T] = size match {
      case 1 => nodes.head
      case _ => {
        val left = nodes.dequeue()
        val right = nodes.dequeue()
        val parent = Node(None, left.weight + right.weight, Some(left), Some(right))
        nodes.enqueue(parent)
        buildHuffmanTreeRec(nodes, nodes.size)
      }
    }

    val nodes = new mutable.PriorityQueue[Node[T]]()(Ordering.by(_.weight))
    nodes.enqueue(nodesList*)

    buildHuffmanTreeRec(nodes, nodes.size)
  }

  /** @return the list of huffman code for the given tree. */
  private def buildHuffmanCodes[T](rootNode: Node[T]): List[(T, String)] = {
    def buildHuffmanCodesRec(node: Node[T], code: String): List[(T, String)] = node match {
      case Node(Some(char), _, _, _) => List((char, code))
      case Node(None, _, Some(left), Some(right)) =>
        buildHuffmanCodesRec(left, code + "0") ++ buildHuffmanCodesRec(right, code + "1")
      case _ => throw new RuntimeException("Unexpected case")
    }

    buildHuffmanCodesRec(rootNode, "")
  }

  case class Node[T](char: Option[T], weight: Int, left: Option[Node[T]] = None, right: Option[Node[T]] = None)
}
