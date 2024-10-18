package ninetynine

/** P32 - Determine the greatest common divisor 
  * of two positive integer numbers.
  */

object P32 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return the greatest common divisor. */
  def gcd(a: Int, b: Int): Int = {
    logger.debug(s"${a} - ${b}")

    @annotation.tailrec
    def gcdPrime(a: BigInt, b: BigInt): BigInt = {
      if (b == 0) a else gcdPrime(b, a % b)  
    }
    gcdPrime(BigInt(a).abs, BigInt(b).abs).toInt
  }
}
