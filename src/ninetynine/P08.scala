package ninetynine

/** P08 - remove the duplicates from a list.
  */

object P08:
  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return l with no duplicates */
  def compress[A](l: List[A]): List[A] =
    logger.debug(s"${l}")

    l.toSet.toList

end P08
