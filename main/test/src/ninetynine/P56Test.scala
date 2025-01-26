package ninetynine

class P56Test extends munit.ScalaCheckSuite:
  import ninetynine.P55.*
  import ninetynine.P56.*

  test("P56 - basic"):
    val symmetricTree = Node('a',
      Node('b', Node('c'), Node('d')),
      Node('b', Node('d'), Node('c'))
    )

    val asymmetricTree = Node('a',
      Node('b', End, Node('c')),
      Node('b', End, Node('c'))
    )

    assert(symmetricTree.isSymmetric)
    assert(!asymmetricTree.isSymmetric)

  test("P56 - no tree with 4 nodes can be symmetric"):
    val result = Tree.cBalanced(4, "x")
    assert(result.forall(!_.isSymmetric))


  test("P56 - 5 trees with 7 nodes will be symmetric"):
    val result = Tree.cBalanced(7, "x")
    assertEquals(result.count(_.isSymmetric), 5)

end P56Test
