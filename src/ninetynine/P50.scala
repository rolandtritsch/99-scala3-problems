package ninetynine

object P50 {
  abstract class Node
  case class Leaf(symbol: Char, weight: Int) extends Node
  case class Internal(left: Node, right: Node, weight: Int) extends Node

  def weight(node: Node): Int = node match {
    case Leaf(_, w) => w
    case Internal(_, _, w) => w
  }

  def huffman(freqs: Set[(Char, Int)]): Node = {
    def combine(nodes: List[Node]): List[Node] = nodes match {
      case left :: right :: rest =>
        val combined = Internal(left, right, weight(left) + weight(right))
        (combined :: rest).sortBy(weight)
      case _ => nodes
    }

    def untilSingle(nodes: List[Node]): Node = nodes match {
      case single :: Nil => single
      case _ => untilSingle(combine(nodes))
    }

    val initialNodes = freqs.map { case (symbol, weight) => Leaf(symbol, weight) }.toList
    untilSingle(initialNodes.sortBy(weight))
  }

  def encode(tree: Node): Set[(Char, String)] = {
    def loop(node: Node, prefix: String): Set[(Char, String)] = node match {
      case Leaf(symbol, _) => Set((symbol, prefix))
      case Internal(left, right, _) =>
        loop(left, prefix + "0") ++ loop(right, prefix + "1")
    }

    loop(tree, "")
  }
}