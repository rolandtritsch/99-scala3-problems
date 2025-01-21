package ninetynine

/** P07 - flatten a nested list structure.
  */

object P07:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** @return flattened list l */
  def flatten(l: Any): List[Any] =
    logger.debug(s"${l}")

    l match
      case Nil          => Nil
      case head :: tail => flatten(head) ++ flatten(tail)
      case e            => List(e)

  end flatten

end P07
