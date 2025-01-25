package ninetynine

/** P55 - Generate complete binary tree.
  */

object P55:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  sealed abstract class Tree[+T]
  case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]
  case object End extends Tree[Nothing]

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

  end Tree

end P55
