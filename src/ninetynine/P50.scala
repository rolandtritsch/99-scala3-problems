package ninetynine

/** P50 - Huffman code.
  *
  * First of all, study a good paper on Huffman coding. In this problem, we will implement the
  * so-called greedy algorithm for constructing Huffman codes.
  *
  * Your task is to construct a Huffman code tree for a given set of characters with their
  * frequencies.
  *
  * Example:
  *   scala> huffman(List(('a', 45), ('b', 13), ('c', 12), ('d', 16), ('e', 9), ('f', 5)))
  *   res0: List[(Char, String)] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))
  */

object P50 {
  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  def huffman[T](list: List[(T, Int)]): List[(T, String)] = {
    logger.debug(s"${list}")

    val nodes = list.map { case (char, freq) => Node(Some(char), freq) }
    val tree = huffmanTree(nodes)
    val codes = huffmanCodes(tree)
    logger.debug(s"Huffman codes: $codes")
    codes
  }

  private def huffmanTree[T](nodes: List[Node[T]]): Node[T] = {
    import scala.collection.mutable

    val queue = new mutable.PriorityQueue[Node[T]]()(Ordering.by(_.weight))
    queue.enqueue(nodes*)

    while (queue.size > 1) {
      val left = queue.dequeue()
      val right = queue.dequeue()
      val parent = Node(None, left.weight + right.weight, Some(left), Some(right))
      queue.enqueue(parent)
    }

    queue.dequeue()
  }

  private def huffmanCodes[T](tree: Node[T]): List[(T, String)] = {
    def huffmanCodesRec(node: Node[T], code: String): List[(T, String)] = node match {
      case Node(Some(char), _, _, _) => List((char, code))
      case Node(None, _, Some(left), Some(right)) =>
        huffmanCodesRec(left, code + "0") ++ huffmanCodesRec(right, code + "1")
      case _ => throw new RuntimeException("Unexpected case")
    }

    huffmanCodesRec(tree, "")
  }

  case class Node[T](char: Option[T], weight: Int, left: Option[Node[T]] = None, right: Option[Node[T]] = None)
}