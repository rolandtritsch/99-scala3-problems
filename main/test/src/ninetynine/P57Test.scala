package ninetynine

class P57Test extends munit.ScalaCheckSuite:
  import P55.*

  property("addValue should add elements to the binary search tree correctly"):
    val tree = Tree.fromList(List(3, 2, 5, 7, 1))
    val expected = Node(3, Node(2, Node(1, End, End), End), Node(5, End, Node(7, End, End)))
    assertEquals(tree, expected)
