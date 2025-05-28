package ninetynine

/** P59 - Construct height-balanced binary trees.
  */

object P59:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  sealed abstract class Tree[+T]:
    def height: Int = this match
      case End => 0
      case Node(_, left, right) => 1 + (left.height max right.height)

    def count: Int = this match
      case End => 0
      case Node(_, left, right) => 1 + left.count + right.count

  case class Node[+T](value: T, left: Tree[T] = End, right: Tree[T] = End) extends Tree[T]
  case object End extends Tree[Nothing]

  object Tree:

    /** @return
      *   all height-balanced binary trees with the given height.
      */
    def hbalTrees[T](height: Int, value: T): List[Tree[T]] =
      if height == 0 then List(End)
      else if height == 1 then List(Node(value, End, End))
      else
        val subTrees1 = hbalTrees(height - 1, value)
        val subTrees2 = hbalTrees(height - 2, value)
        
        val combination1 = for
          left <- subTrees1
          right <- subTrees1
        yield Node(value, left, right)
        
        val combination2 = for
          left <- subTrees1
          right <- subTrees2
        yield Node(value, left, right)
        
        val combination3 = for
          left <- subTrees2
          right <- subTrees1
        yield Node(value, left, right)
        
        (combination1 ++ combination2 ++ combination3).toList
      end if
    end hbalTrees

    /** @return
      *   the minimum number of nodes in a height-balanced tree of given height.
      */
    def minHbalNodes(height: Int): Int =
      if height == 0 then 0
      else if height == 1 then 1
      else 1 + minHbalNodes(height - 1) + minHbalNodes(height - 2)
    end minHbalNodes

    /** @return
      *   the maximum height of a height-balanced tree with given number of nodes.
      */
    def maxHbalHeight(nodes: Int): Int =
      if nodes == 0 then 0
      else
        def findMaxHeight(h: Int): Int =
          if minHbalNodes(h) <= nodes then findMaxHeight(h + 1)
          else h - 1
        findMaxHeight(1)
    end maxHbalHeight

    /** @return
      *   all height-balanced binary trees with the given number of nodes.
      */
    def hbalTreesWithNodes[T](nodes: Int, value: T): List[Tree[T]] =
      if nodes == 0 then List(End)
      else
        val maxHeight = maxHbalHeight(nodes)
        val minHeight = LazyList.from(1).takeWhile(h => minHbalNodes(h) <= nodes).last
        
        (minHeight to maxHeight).flatMap(h => hbalTrees(h, value))
          .filter(_.count == nodes)
          .toList
    end hbalTreesWithNodes

  end Tree

end P59