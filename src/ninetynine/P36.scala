package ninetynine

/** P36 Determine the prime factorization of a given positive integer.
  */

object P36 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return a list of tuples containing prime factors and their multiplicity. */
  def primeFactorMultiplicity(n: Int): List[(Int, Int)] = {
    logger.debug(s"${n}")

    @annotation.tailrec
    def primeFactorsR(n: Int, p: Int, factors: List[(Int, Int)]): List[(Int, Int)] = {
      if (n < 2) factors
      else if (n % p == 0) {
        val (factor, count) = factors.headOption.getOrElse((p, 0))
        if (factor == p) {
          primeFactorsR(n / p, p, (p, count + 1) :: factors.tail)
        } else {
          primeFactorsR(n / p, p, (p, 1) :: factors)
        }
      } else {
        primeFactorsR(n, p + 1, factors)
      }
    }

    primeFactorsR(n, 2, List()).reverse
  }
}