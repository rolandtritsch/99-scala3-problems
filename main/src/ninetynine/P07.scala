package ninetynine

import com.typesafe.scalalogging.Logger

/** P07 - flatten a (potentially nested) list of lists.
  */

object P07:
  val logger: Logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return flattened list l */
  def flatten(l: Any): List[Any] =
    logger.debug(s"${l}")

    l match
      case Nil          => Nil
      case head :: tail => flatten(head) ++ flatten(tail)
      case e            => List(e)

  end flatten

end P07
