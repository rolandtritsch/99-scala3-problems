package ninetynine

/** P15 - duplicate the elements of a list a given number of times.
  */

object P15 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  final def duplicate(n: Int, l: List[Any]): List[Any] = {
    assert(!l.isEmpty, "!l.isEmpty")
    logger.debug(s"${l}")

    (for(e <- l) yield List.fill(n)(e)).flatten
  }
}
