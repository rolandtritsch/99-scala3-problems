package ninetynine

/** P02 - find last but one element of a list.
  */

object P02:
  val logger = com.typesafe.scalalogging.Logger(getClass)

  /** @return the last but one element of the list l */
  @annotation.tailrec
  def penultimate[A](l: List[A]): A =
    require(l.size >= 2, "l.size >= 2")
    logger.debug(s"${l}")

    l match
      case e :: _ :: Nil => e
      case _ :: rest     => penultimate(rest)
      case _             => throw new RuntimeException("Unexpected case")

  end penultimate

end P02
