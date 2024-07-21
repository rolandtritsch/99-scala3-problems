package ninetynine

/** P11 - modified run-length encoding
  */

object P11 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return run-length encoded list */
  final def encode(l: List[Any]): List[Any] = {
    assert(!l.isEmpty, "!l.empty")
    logger.debug(s"${l}")

    def encode(l: List[Any], el: List[Any], ec: (Int, Any)): List[Any] = {
      logger.debug(s"${l}")

      l match {
        case Nil if ec._1 == 1       => el ++ List(ec._2)
        case Nil                     => el ++ List(ec)
        case e :: rest if e == ec._2 => encode(rest, el, (ec._1 + 1, ec._2))
        case e :: rest if ec._1 == 1 => encode(rest, el ++ List(ec._2), (1, e))
        case e :: rest               => encode(rest, el ++ List(ec), (1, e))
      }
    }

    encode(l.tail, List(), (1, l.head))
  }
}
