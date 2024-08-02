package ninetynine

/** P08 - remove the duplicates from a list.
  */

object P08 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return l with no duplicates */
  final def compress[A](l: List[A]): List[A] = {
    logger.debug(s"${l}")

    l.toSet.toList
  }
}
