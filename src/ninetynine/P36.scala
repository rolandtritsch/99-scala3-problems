package ninetynine

/** P36 Determine the prime factorization of a given positive integer.
  */

object P36 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return a list of tuples containing prime factors and their multiplicity. */
  def primeFactorMultiplicity(n: Int): List[(Int, Int)] = {
    logger.debug(s"${n}")

    P35.primeFactors(n).groupBy(identity).view.mapValues(_.size).toList.sorted
  }
}