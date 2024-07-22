package ninetynine

/** P10 - run-length encoding of a list.
  */

object P10 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return run-length encoded list */
  final def encode[A](l: List[A]): List[(Int, A)] = {
    logger.debug(s"${l}")

    def encode(
        l: List[A],
        el: List[(Int, A)],
        ec: (Int, A)
    ): List[(Int, A)] = {
      logger.debug(s"${l}")

      l match {
        case Nil                     => el ++ List(ec)
        case e :: rest if e == ec._2 => encode(rest, el, (ec._1 + 1, ec._2))
        case e :: rest               => encode(rest, el ++ List(ec), (1, e))
      }
    }

    l match {
      case Nil => List()
      case _   => encode(l.tail, List(), (1, l.head))
    }
  }
}
