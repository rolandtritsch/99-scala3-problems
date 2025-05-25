package ninetynine

import org.scalacheck.Gen
import org.scalacheck.Prop.*

class P58Test extends munit.ScalaCheckSuite:

  import ninetynine.P55.*
  import ninetynine.P56.*

  test("P58 - basic test with 5 nodes"):
    val result = P58.Tree.symmetricBalancedTrees(5, "x")
    assertEquals(result.size, 2)

    // All trees should be symmetric
    assert(result.forall(_.isSymmetric))

    // All trees should have 5 nodes
    def countNodes(tree: Tree[String]): Int = tree match
      case End                  => 0
      case Node(_, left, right) => 1 + countNodes(left) + countNodes(right)

    assert(result.forall(countNodes(_) == 5))

  test("P58 - empty tree"):
    val result = P58.Tree.symmetricBalancedTrees(0, "x")
    assertEquals(result.size, 1)
    assertEquals(result.head, End)

  test("P58 - single node"):
    val result = P58.Tree.symmetricBalancedTrees(1, "x")
    assertEquals(result.size, 1)
    assertEquals(result.head, Node("x", End, End))

  test("P58 - two nodes (no symmetric balanced trees)"):
    val result = P58.Tree.symmetricBalancedTrees(2, "x")
    assertEquals(result.size, 0)

  test("P58 - three nodes"):
    val result = P58.Tree.symmetricBalancedTrees(3, "x")
    assertEquals(result.size, 1)
    assertEquals(result.head, Node("x", Node("x", End, End), Node("x", End, End)))

  test("P58 - four nodes (no symmetric balanced trees)"):
    val result = P58.Tree.symmetricBalancedTrees(4, "x")
    assertEquals(result.size, 0)

  test("P58 - seven nodes"):
    val result = P58.Tree.symmetricBalancedTrees(7, "x")
    assertEquals(result.size, 5)
    assert(result.forall(_.isSymmetric))

  property("P58 - all generated trees are symmetric and balanced"):
    forAll(Gen.choose(0, 10)) { n =>
      val result = P58.Tree.symmetricBalancedTrees(n, "x")

      // All should be symmetric
      result.forall(_.isSymmetric) &&
      // All should be in the set of completely balanced trees
      result.forall(P55.Tree.cBalanced(n, "x").contains(_))
    }

end P58Test
