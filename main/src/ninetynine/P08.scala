package ninetynine

/** P08 - eliminate consecutive duplicates of list elements.
  */

object P08:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** @return l with no duplicates */
  def compress[A](l: List[A]): List[A] =
    logger.debug(s"${l}")

    l.toSet.toList

end P08
