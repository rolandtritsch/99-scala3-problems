package ninetynine

/** P26 - generate the combinations of K distinct elements chosen from
  * the N elements of a list.
  */

object P26 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** Iterate over the list and remove one element at a time.  Do this K
    * times recursivly and keep track on the elements that you take
    * out.  When you have recursed N times into it you need to iterate
    * over everything that is left over.
    *
    * @return the generated list of combinations
    */
  final def combinations[A](k: Int, l: List[A]): List[List[A]] = {
    logger.debug(s"${k} - ${l}")

    combinations(k, l, List[A]())
  }

  private def combinations[A](k: Int, tail: List[A], head: List[A]): List[List[A]] = {
    assert(k >= 1, "k >= 1")
    assert(!tail.isEmpty, "!tail.isEmpty")

    // Just build the combinations of the head and the remaining
    // elements.
    if(k == 1) for(e <- tail) yield head :+ e

    // otherwise remove another element from whats left over, add it
    // to the head and do it again.
    else {
      var result = List[List[A]]()
      for(i <- 0 until tail.size) {
        result = result ++ combinations(k - 1, removeAtIndex(i, tail), head :+ tail(i))
      }
      result
    }
  }

  private def removeAtIndex[A](index: Int, l: List[A]): List[A] = {
    val s = l.splitAt(index)
    s._1 ::: s._2.drop(1)
  }
}
