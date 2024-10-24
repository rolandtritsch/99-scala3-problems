package ninetynine

/** P02 - find the last but one element of the list.
  */

object P02 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return the last but one element of the list l */
  @annotation.tailrec
  final def penultimate[A](l: List[A]): A = {
    require(l.size >= 2, "l.size >= 2")
    logger.debug(s"${l}")

    l match {
      case e :: _ :: Nil => e
      case _ :: rest     => penultimate(rest)
      case _             => throw new RuntimeException("Unexpected case")
    }
  }
}
