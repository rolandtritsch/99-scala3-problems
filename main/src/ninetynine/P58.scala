package ninetynine

/** P58 - Generate-and-test paradigm.
  *
  * Apply the generate-and-test paradigm to construct all symmetric, completely balanced binary
  * trees with a given number of nodes.
  */

object P58:

  import ninetynine.P55.*
  import ninetynine.P56.*

  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  object Tree:

    /** Generate all symmetric, completely balanced binary trees with the given number of nodes.
      *
      * @param n
      *   the number of nodes in the tree
      * @param value
      *   the value to put in each node
      * @return
      *   list of all symmetric, completely balanced binary trees with n nodes
      */
    def symmetricBalancedTrees[T](n: Int, value: T): List[Tree[T]] =
      require(n >= 0, "n >= 0")
      logger.debug(s"Generating symmetric balanced trees for n=$n")

      // Generate all completely balanced trees and filter for symmetric ones
      P55.Tree.cBalanced(n, value).filter(_.isSymmetric)
    end symmetricBalancedTrees

  end Tree

end P58
