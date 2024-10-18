package ninetynine

/** P33 - Determine whether two positive integer numbers are coprime.
  */

object P33 {
    final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

    /** @return true if the two numbers are coprime. */
    def coprime(a: Int, b: Int): Boolean = {
        logger.debug(s"${a} - ${b}")

        P32.gcd(a, b) == 1
    }
}