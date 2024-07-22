package ninetynine

/** P07 - flatten a (potentially nested) list of lists.
  */

object P07 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return flattened list l */
  final def flatten(l: Any): List[Any] = {
    logger.debug(s"${l}")

    l match {
      case Nil          => Nil
      case head :: tail => flatten(head) ++ flatten(tail)
      case e            => List(e)
    }
  }
}
