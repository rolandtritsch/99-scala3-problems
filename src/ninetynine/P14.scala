package ninetynine

/** P14 - duplicate the elements of a list.
  */

object P14 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  final def duplicate(l: List[Any]): List[Any] = {
    assert(!l.isEmpty, "!l.isEmpty")
    logger.debug(s"${l}")

    (for(e <- l) yield List(e, e)).flatten
  }
}
