package ninetynine

/** P11 - modified run-length encoding.
  */

object P11 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return run-length encoded list */
  final def encode[A](l: List[A]): List[Any] = {
    logger.debug(s"${l}")

    def encode(l: List[A], el: List[Any], ec: (Int, A)): List[Any] = {
      logger.debug(s"${l}")

      l match {
        case Nil if ec._1 == 1       => el ++ List(ec._2)
        case Nil                     => el ++ List(ec)
        case e :: rest if e == ec._2 => encode(rest, el, (ec._1 + 1, ec._2))
        case e :: rest if ec._1 == 1 => encode(rest, el ++ List(ec._2), (1, e))
        case e :: rest               => encode(rest, el ++ List(ec), (1, e))
      }
    }

    l match {
      case Nil => List[A]()
      case _   => encode(l.tail, List(), (1, l.head))
    }
  }
}
