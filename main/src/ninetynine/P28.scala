package ninetynine

/** P28 - sorting a list of lists according to length of sublists.
  */

object P28:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** @return l sorted by the length of the lists */
  def lsort[A](l: List[List[A]]): List[List[A]] =
    logger.debug(s"${l}")

    l.sortBy(_.size)

  /** lsortFreq - Generic function to sort a list of lists according to the frequency of the size of
    * sublists.
    *
    * @note
    *   The type A must be sortable
    *
    * @param l
    *   list of lists to be sorted
    * @return
    *   l sorted by the frequency of the length of the lists
    */
  def lsortFreq[A: Ordering](l: List[List[A]]): List[List[A]] =
    import Ordering.Implicits.*

    logger.debug(s"${l}")

    val groupedBySize = l.groupBy(_.size).values.toList
    val groupedByFreq = groupedBySize.groupBy(_.size).values.toList
    groupedByFreq.map(_.flatten).flatMap(_.sorted)

  end lsortFreq

end P28
