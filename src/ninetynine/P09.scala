package ninetynine

/** P09 - pack dublicates into sublists.
  */

object P09 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return a list of lists (packing dups into lists) */
  final def pack[A](l: List[A]): List[List[A]] = {
    logger.debug(s"${l}")

    for (i <- l.distinct) yield l.filter(_ == i)
  }
}
