package ninetynine

/** P09 - pack consecutive duplicates of list elements into sublists.
  */

object P09:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** @return a list of lists (packing dups into lists) */
  def pack[A](l: List[A]): List[List[A]] =
    logger.debug(s"${l}")

    for (i <- l.distinct) yield l.filter(_ == i)

end P09
