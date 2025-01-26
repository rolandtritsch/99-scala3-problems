package ninetynine

/** P56 - Symmetric binary trees.
  */

object P56:
  import ninetynine.P55.*

  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  extension[T] (tree: Tree[T])
    def isSymmetric: Boolean =
      def isMirror(t1: Tree[T], t2: Tree[T]): Boolean = (t1, t2) match
        case (End, End) => true
        case (End, _) => false
        case (_, End) => false
        case (Node(v1, l1, r1), Node(v2, l2, r2)) => 
          v1 == v2 && isMirror(l1, r2) && isMirror(r1, l2)
  
      tree match
        case Node(_, left, right) => isMirror(left, right)
        case End => true

end P56
