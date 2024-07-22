package ninetynine

/** P18 - extract a slice from a list.
  */

object P18 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return the slice from/to of list l */
  final def slice[A](from: Int, to: Int, l: List[A]): List[A] = {
    logger.debug(s"${l}")

    (for(i <- 0 until l.size; if(i >= from && i < to)) yield l(i)).toList
  }
}
