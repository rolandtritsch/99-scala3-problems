// Problem P57: Binary search trees (dictionaries)

object P57:
  import ninetynine.P55.*
  import ninetynine.P56.*

  extension [T: Ordering](tree: Tree[T])
    def addValue(value: T): Tree[T] = tree match
      case End => Node(value, End, End)
      case Node(v, left, right) =>
        if summon[Ordering[T]].lt(value, v) then Node(v, left.addValue(value), right)
        else Node(v, left, right.addValue(value))

  object Tree:
    def fromList[T: Ordering](list: List[T]): Tree[T] =
      list.foldLeft(End: Tree[T])((tree, elem) => tree.addValue(elem))

  @main def testP57(): Unit =
    val tree = Tree.fromList(List(3, 2, 5, 7, 1))
    println(tree)
    println(tree.isSymmetric)
