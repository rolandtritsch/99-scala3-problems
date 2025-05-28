package ninetynine

class P59Test extends munit.ScalaCheckSuite:

  import P59.Tree
  import P59.Node
  import P59.End

  test("P59 - with 10 nodes"):
    val result = Tree.hbalTreesWithNodes(10, "x")
    assertEquals(result.size, 60)
    
    // Check that all trees have exactly 10 nodes
    result.foreach(tree => assertEquals(tree.count, 10))
    
    // Check that all trees are height-balanced
    def isBalanced(tree: P59.Tree[?]): Boolean = tree match
      case End => true
      case Node(_, left, right) =>
        val lh = left.height
        val rh = right.height
        (lh - rh).abs <= 1 && isBalanced(left) && isBalanced(right)
    end isBalanced
    
    result.foreach(tree => assert(isBalanced(tree)))

  test("P59 - empty tree"):
    val result = Tree.hbalTrees(0, "x")
    assertEquals(result.size, 1)
    assertEquals(result.head, End)

  test("P59 - hbalTrees"):
    val trees1 = Tree.hbalTrees(1, "x")
    assertEquals(trees1.size, 1)

    val trees2 = Tree.hbalTrees(2, "x")
    assertEquals(trees2.size, 3)

    val trees3 = Tree.hbalTrees(3, "x")
    assert(trees3.size > 0)

    // Test that all trees have the correct height
    trees3.foreach(tree => assertEquals(tree.height, 3))

    // Test that all trees are height-balanced
    def isBalanced(tree: P59.Tree[?]): Boolean = tree match
      case End => true
      case Node(_, left, right) =>
        val lh = left.height
        val rh = right.height
        (lh - rh).abs <= 1 && isBalanced(left) && isBalanced(right)
    end isBalanced

    trees3.foreach(tree => assert(isBalanced(tree)))

  test("P59 - minHbalNodes"):
    assertEquals(Tree.minHbalNodes(0), 0)
    assertEquals(Tree.minHbalNodes(1), 1)
    assertEquals(Tree.minHbalNodes(2), 2)
    assertEquals(Tree.minHbalNodes(3), 4)
    assertEquals(Tree.minHbalNodes(4), 7)
    assertEquals(Tree.minHbalNodes(5), 12)

  test("P59 - maxHbalHeight"):
    assertEquals(Tree.maxHbalHeight(0), 0)
    assertEquals(Tree.maxHbalHeight(1), 1)
    assertEquals(Tree.maxHbalHeight(2), 2)
    assertEquals(Tree.maxHbalHeight(4), 3)
    assertEquals(Tree.maxHbalHeight(7), 4)
    assertEquals(Tree.maxHbalHeight(12), 5)

  test("P59 - hbalTreesWithNodes"):
    val trees1 = Tree.hbalTreesWithNodes(1, "x")
    assertEquals(trees1.size, 1)

    val trees4 = Tree.hbalTreesWithNodes(4, "x")
    assert(trees4.size > 0)

    // Test that all trees have the correct number of nodes
    trees4.foreach(tree => assertEquals(tree.count, 4))

    // Test that all trees are height-balanced
    def isBalanced(tree: P59.Tree[?]): Boolean = tree match
      case End => true
      case Node(_, left, right) =>
        val lh = left.height
        val rh = right.height
        (lh - rh).abs <= 1 && isBalanced(left) && isBalanced(right)
    end isBalanced

    trees4.foreach(tree => assert(isBalanced(tree)))

end P59Test
