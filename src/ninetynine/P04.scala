package ninetynine

/** P04 - find the number of elements in the list.
  */

object P04 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return the size of the list l */
  final def size(l: List[Any]): Int = {
    logger.debug(s"${l}")

    l match {
      case Nil       => 0
      case _ :: rest => size(rest) + 1
    }
  }
}
