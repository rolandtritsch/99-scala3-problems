package ninetynine

/** P04 - find the number of elements in a list.
  */

object P04:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** @return the size of the list l */
  def size(l: List[Any]): Int =
    logger.debug(s"${l}")

    @annotation.tailrec
    def size(l: List[Any], s: Int): Int = l match
      case Nil       => s
      case _ :: rest => size(rest, s + 1)
    size(l, 0)

  end size

end P04
