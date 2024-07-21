package ninetynine

/** P07 - flatten a (potentially nested) list of lists.
  */

object P07 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return flattened list nested */
  final def flatten(nested: Any): List[Any] = {
    logger.debug(s"${nested}")

    nested match {
      case Nil          => Nil
      case head :: tail => flatten(head) ::: flatten(tail)
      case e            => List(e)
    }
  }
}
