package

/** P28 - Sorting a list of lists according to length of sublists.
  */

object P28 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return l sorted by the length of the lists */
  final def lsort[A](l: List[List[A]]): List[List[A]] = {
    logger.debug(s"${l}")

    l.sortBy(_.size)
  }

  final def lsortFreq[A](l: List[List[A]]): List[List[A]] = {
    List(List())
  }
}
