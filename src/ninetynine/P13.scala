package ninetynine

/** P13 - Run-length encoding of a list (direct (recursive) solution)
  */

object P13 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return run-length encoded list */
  final def encode(l: List[Any]): List[(Int, Any)] = {
    assert(!l.isEmpty, "!l.empty")
    logger.debug(s"${l}")

    def encode(rest: List[Any], original: List[Any]): List[(Int, Any)] = {
      val current = (original.count(rest.head == _), rest.head)
      if (rest.size == 1) List(current)
      else current :: encode(rest.tail, original)
    }

    encode(l.distinct, l)
  }
}
