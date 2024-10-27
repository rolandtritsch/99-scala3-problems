package ninetynine

/** P32 - Determine the greatest common divisor 
  * of two positive integer numbers.
  *
  * @note This implements the [[https://en.wikipedia.org/wiki/Euclidean_algorithm Euclidean algorithm]].
  */

object P32 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return the greatest common divisor. */
  def gcd(a: Int, b: Int): Int = {
    logger.debug(s"${a} - ${b}")

    @annotation.tailrec
    def gcd(a: BigInt, b: BigInt): BigInt = {
      if (b == 0) a else gcd(b, a % b)
    }
    gcd(BigInt(a).abs, BigInt(b).abs).toInt
  }
}
