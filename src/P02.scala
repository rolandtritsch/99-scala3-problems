package ninetynine

/** P02 - return the last but one element of the list.
  */

object P02 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  final def penultimate[T](l: List[T]): T = {
    assert(l.size >= 2, "l.size >= 2")
    logger.debug(s"${l}")

    l match {
      case e :: _ :: Nil => e
      case _ :: rest     => penultimate(rest)
      case _             => throw new RuntimeException("Unexpected case")
    }
  }
}
