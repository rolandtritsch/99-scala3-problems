package ninetynine

/** P12 - decode a run-length encoded list
  */

object P12 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return run-length decoded list */
  final def decode(l: List[(Int, Any)]): List[Any] = {
    assert(!l.isEmpty, "!l.empty")
    logger.debug(s"${l}")

    (for (i <- l; c = i._1; e = i._2) yield List.fill(c)(e)).flatten
  }
}
