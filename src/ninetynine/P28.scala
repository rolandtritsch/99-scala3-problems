package ninetynine

/** P28 - Sorting a list of lists according to length of sublists.
  */

object P28 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return l sorted by the length of the lists */
  final def lsort[A](l: List[List[A]]): List[List[A]] = {
    logger.debug(s"${l}")

    l.sortBy(_.size)
  }

  /** lsortFreq - Generic function to sort a list of lists according
    * to the frequency of the size of sublists.
    *
    * @note The type A must be sortable
    *
    * @param l list of lists to be sorted
    * @return l sorted by the frequency of the length of the lists
    */
  final def lsortFreq[A: Ordering](l: List[List[A]]): List[List[A]] = {
    import Ordering.Implicits._

    logger.debug(s"${l}")

    val groupedBySize = l.groupBy(_.size).values.toList
    val groupedByFreq = groupedBySize.groupBy(_.size).values.toList
    groupedByFreq.map(_.flatten).map(_.sorted).flatten
  }
}
