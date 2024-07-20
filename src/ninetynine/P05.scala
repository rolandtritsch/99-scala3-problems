package ninetynine

/** P05 - reverse a list.
  */

object P05 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return the reverse of the list l */
  final def reverse(l: List[Any]): List[Any] = {
    logger.debug("${l}")

    l match {
      case Nil       => List()
      case e :: Nil  => List(e)
      case e :: rest => reverse(rest) ++ List(e)
    }
  }
}
