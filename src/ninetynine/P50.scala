package ninetynine

object P50 {
  abstract class Node[A]
  case class Leaf[A](symbol: A, weight: Int) extends Node[A]
  case class Internal[A](left: Node[A], right: Node[A], weight: Int, maxSymbol: A) extends Node[A]

  def weight[A](node: Node[A]): Int = node match {
    case Leaf(_, w) => w
    case Internal(_, _, w, _) => w
  }
  
  def maxSymbol[A](node: Node[A]): A = node match {
    case Leaf(c, _) => c
    case Internal(_, _, _, c) => c
  }
  
  def max[A: Ordering](a: A, b: A): A = {
    val ord = implicitly[Ordering[A]]
    if (ord.gt(a, b)) a else b
  }

  def weightAndMaxSymbol[A](node: Node[A]): (Int, A) = node match {
    case Leaf(s, w) => (w, s)
    case Internal(_, _, w, s) => (w, s)
  }

  def huffman(text: String): Node[Char] = {
    val freqs = text.groupBy(identity).map { (c, cs) => (c, cs.length) }.toSet
    huffman(freqs)
  }

  def huffman[A: Ordering](freqs: Set[(A, Int)]): Node[A] = {
    def combine[A: Ordering](nodes: List[Node[A]]): List[Node[A]] = nodes match {
      case left :: right :: rest =>
        val combined = Internal(left, right, weight(left) + weight(right), max(maxSymbol(left), maxSymbol(right)))
        (combined :: rest).sortBy(weightAndMaxSymbol)
      case _ => nodes
    }

    def untilSingle[A: Ordering](nodes: List[Node[A]]): Node[A] = nodes match {
      case single :: Nil => single
      case _ => untilSingle(combine(nodes))
    }

    val initialNodes = freqs.map { (symbol, weight) => Leaf(symbol, weight) }.toList
    untilSingle(initialNodes.sortBy(weightAndMaxSymbol))
  }

  def encode[A](tree: Node[A]): Set[(A, String)] = {
    def loop[A](node: Node[A], prefix: String): Set[(A, String)] = node match {
      case Leaf(symbol, _) => Set((symbol, prefix))
      case Internal(left, right, _, _) =>
        loop(left, prefix + "0") ++ loop(right, prefix + "1")
    }

    loop(tree, "")
  }
}