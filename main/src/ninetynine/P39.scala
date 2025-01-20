package ninetynine

import com.typesafe.scalalogging.Logger

/** P39 - A list of prime numbers.
  */

object P39:
  val logger: Logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return List of prime numbers in the given range. */
  def listPrimesInRange(range: Range): List[Int] =
    require(range.start > 1, "range.start > 1")
    logger.debug(s"${range}")

    range.filter(P31.isPrime).toList

  end listPrimesInRange

end P39
