package ninetynine

/** P31 - Determine whether a given integer number is prime.
  *
  * @note This implements the [[https://www.khanacademy.org/computing/computer-science/cryptography/comp-number-theory/a/trial-division Trial division algorithm]].
  */

object P31 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return true, if the number is prime. */
  def isPrime(n: Int): Boolean = {
    require(n > 1, "n > 1")
    logger.debug(s"${n}")

    val wall = 2 to Math.sqrt(n).toInt
    val isNotPrime = LazyList(wall*).exists(n % _ == 0)
    !isNotPrime
  }
}
