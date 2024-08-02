package ninetynine

/** P16 - drop every Nth element from a list.
  */

object P16 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return the list l without every Nth element */
  final def drop[A](n: Int, l: List[A]): List[A] = {
    logger.debug(s"${l}")

    (for (i <- 1 until l.size + 1; if i % n != 0) yield l(i - 1)).toList
  }
}
