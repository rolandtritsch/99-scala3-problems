package ninetynine

/** P01 - return the last element of the list.
  */

object P01 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  final def last[T](l: List[T]): T = {
    assert(!l.isEmpty, "!l.isEmpty")
    logger.debug(s"${l}")

    l match {
      case e :: Nil  => e
      case _ :: rest => last(rest)
      case _         => throw new RuntimeException("Unexpected case")
    }
  }
}
