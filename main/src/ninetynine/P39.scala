package ninetynine

/** P39 - a list of prime numbers.
  */

object P39:
  val logger = com.typesafe.scalalogging.Logger(getClass)

  /** @return List of prime numbers in the given range. */
  def listPrimesInRange(range: Range): List[Int] =
    require(range.start > 1, "range.start > 1")
    logger.debug(s"${range}")

    range.filter(P31.isPrime).toList

  end listPrimesInRange

end P39
