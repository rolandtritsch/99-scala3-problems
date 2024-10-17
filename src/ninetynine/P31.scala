package ninetynine

import scala.util.boundary, boundary.break

/** P31 - Determine whether a given integer number is prime.
  */

object P31 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return true, if the number is prime. */
  def isPrime(n: Int): Boolean = {
    logger.debug(s"${n}")

    if (n <= 1) false
    else {
      boundary:
        for (i <- 2 to Math.sqrt(n).toInt) {
          if (n % i == 0) break(false)
        }
        true        
    }
  }
}
