package ninetynine

/** P59 - Construct height-balanced binary trees.
  * 
  * In a height-balanced binary tree, the following property holds for every node: 
  * The height of its left subtree and the height of its right subtree are almost equal, 
  * which means their difference is not greater than one.
  */

object P59:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  sealed abstract class Tree[+T]:
    /** @return the height of the tree */
    def height: Int = this match
      case End => 0
      case Node(_, left, right) => 1 + (left.height max right.height)
    end height
  end Tree

  case class Node[+T](value: T, left: Tree[T] = End, right: Tree[T] = End) extends Tree[T]
  case object End extends Tree[Nothing]

  object Tree:
    /** Construct all height-balanced binary trees with the given height and node value.
      *
      * @param height the required height of the trees
      * @param value the value to be used in all nodes
      * @return a list of all possible height-balanced binary trees with the given height
      */
    def hbalTrees[T](height: Int, value: T): List[Tree[T]] =
      if height <= 0 then List(End)
      else if height == 1 then List(Node(value))
      else if height == 2 then
        // For height=2, we have exactly two patterns:
        // 1. Node with two leaf nodes: Node(value, Node(value), Node(value))
        // 2. Node with one leaf node: Node(value, Node(value), End) and Node(value, End, Node(value))
        List(
          Node(value, Node(value), Node(value)),
          Node(value, Node(value), End),
          Node(value, End, Node(value))
        ).distinct // Use distinct to remove any duplicates
      else
        // For height h, we can have:
        // - left subtree with height h-1 and right subtree with height h-1
        // - left subtree with height h-1 and right subtree with height h-2
        // - left subtree with height h-2 and right subtree with height h-1
        val subtrees1 = hbalTrees(height - 1, value)
        val subtrees2 = hbalTrees(height - 2, value)
        
        // Trees with both subtrees of height h-1
        val trees1 = for
          leftTree <- subtrees1
          rightTree <- subtrees1
        yield Node(value, leftTree, rightTree)
        
        // Trees with left subtree of height h-1 and right subtree of height h-2
        val trees2 = for
          leftTree <- subtrees1
          rightTree <- subtrees2
        yield Node(value, leftTree, rightTree)
        
        // Trees with left subtree of height h-2 and right subtree of height h-1
        val trees3 = for
          leftTree <- subtrees2
          rightTree <- subtrees1
        yield Node(value, leftTree, rightTree)
        
        (trees1 ++ trees2 ++ trees3).distinct // Use distinct to remove any duplicates
    end hbalTrees

    /** Calculates the minimum number of nodes in a height-balanced binary tree of height h.
      *
      * @param height the height of the tree
      * @return the minimum number of nodes in a height-balanced binary tree of height h
      */
    def minHbalNodes(height: Int): Int =
      if height <= 0 then 0
      else if height == 1 then 1
      else minHbalNodes(height - 1) + minHbalNodes(height - 2) + 1
    end minHbalNodes

    /** Calculates the maximum height of a height-balanced binary tree with n nodes.
      *
      * @param nodes the number of nodes
      * @return the maximum height of a height-balanced binary tree with n nodes
      */
    def maxHbalHeight(nodes: Int): Int =
      if nodes <= 0 then 0
      else if nodes == 1 then 1
      else
        // Binary search to find the maximum height
        @annotation.tailrec
        def search(low: Int, high: Int): Int =
          if low >= high then low
          else
            val mid = (low + high + 1) / 2
            if minHbalNodes(mid) <= nodes then search(mid, high)
            else search(low, mid - 1)
        end search
        
        search(1, nodes)
    end maxHbalHeight

    /** Construct all height-balanced binary trees with the given number of nodes.
      *
      * @param nodes the required number of nodes
      * @param value the value to be used in all nodes
      * @return a list of all possible height-balanced binary trees with the given number of nodes
      */
    def hbalTreesWithNodes[T](nodes: Int, value: T): List[Tree[T]] =
      if nodes <= 0 then List(End)
      else if nodes == 1 then List(Node(value))
      else
        val minHeight = 1
        val maxHeight = maxHbalHeight(nodes)
        
        (minHeight to maxHeight).flatMap { h =>
          hbalTrees(h, value).filter(_.count == nodes)
        }.toList
    end hbalTreesWithNodes
    
    extension [T](tree: Tree[T])
      /** Count the number of nodes in a tree */
      def count: Int = tree match
        case End => 0
        case Node(_, left, right) => 1 + left.count + right.count
      end count
    end extension
    
  end Tree

end P59
