package ninetynine

/** P55 - Construct completely balanced binary trees.
  */

object P55:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  sealed abstract class Tree[+T]
  case class Node[+T](value: T, left: Tree[T] = End, right: Tree[T] = End) extends Tree[T]
  case object End extends Tree[Nothing]

  import scala.math.Ordered.orderingToOrdered

  extension [T: Ordering](tree: Tree[T])

    def addValue(value: T): Tree[T] = tree match
      case End => Node(value, End, End)
      case Node(v, left, right) =>
        if value == v then tree
        else if value < v then Node(v, left.addValue(value), right)
        else Node(v, left, right.addValue(value))
    end addValue

  end extension

  object Tree:

    /** @return
      *   the List of all balanced binary trees for the given number of nodes.
      */
    def cBalanced[T](n: Int, value: T): List[Tree[T]] =
      if n == 0 then List(End)
      else if n == 1 then List(Node(value, End, End))
      else
        (for
          leftNodes <- 0 until n
          rightNodes = n - 1 - leftNodes
          leftTree <- cBalanced(leftNodes, value)
          rightTree <- cBalanced(rightNodes, value)
        yield Node(value, leftTree, rightTree)).toList
      end if
    end cBalanced

    /** @return
      *   the Tree from the given List.
      */
    // format: off
    def fromList[T: Ordering](list: List[T]): Tree[T] =
      list.foldLeft(End: Tree[T])((tree, elem) => tree.addValue(elem))
    end fromList
    // format: on

  end Tree

end P55
