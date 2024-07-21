package ninetynine

/** P10 - run-length encoding of a list.
  */

object P10 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return run-length encoded list */
  final def encode(l: List[Any]): List[(Int, Any)] = {
    assert(!l.isEmpty, "!l.empty")
    logger.debug(s"${l}")

    def encode(
        l: List[Any],
        el: List[(Int, Any)],
        ec: (Int, Any)
    ): List[(Int, Any)] = {
      logger.debug(s"${l}")

      l match {
        case Nil                     => el ++ List(ec)
        case e :: rest if e == ec._2 => encode(rest, el, (ec._1 + 1, ec._2))
        case e :: rest               => encode(rest, el ++ List(ec), (1, e))
      }
    }

    encode(l.tail, List(), (1, l.head))
  }
}
