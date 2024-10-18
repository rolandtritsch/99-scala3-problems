package ninetynine

/** P04 - find the number of elements in the list.
  */

object P04 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return the size of the list l */
  final def size(l: List[Any]): Int = {
    logger.debug(s"${l}")

    @annotation.tailrec
    def size(l: List[Any], s: Int): Int = {
      l match {
        case Nil       => s
        case _ :: rest => size(rest, s + 1)
      }
    }
    size(l, 0)
  }
}
