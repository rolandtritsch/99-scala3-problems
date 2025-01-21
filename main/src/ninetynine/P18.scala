package ninetynine

/** P18 - extract a slice from a list.
  */

object P18:
  val logger = com.typesafe.scalalogging.Logger(getClass)

  /** @return the slice from/to of list l */
  def slice[A](from: Int, to: Int, l: List[A]): List[A] =
    logger.debug(s"${l}")

    (for (i <- 0 until l.size; if (i >= from && i < to)) yield l(i)).toList

end P18
