package ninetynine

/** P08 - remove the duplicates from a list
  */

object P08 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return l with no duplicates */
  final def compress(l: List[Any]): List[Any] = {
    logger.debug(s"${l}")

    // l.distinct
    l.toSet.toList
  }
}
