package ninetynine

/** P36 - determine the prime factors of a given positive integer (2).
  */

object P36:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** @return a list of tuples containing prime factors and their multiplicity. */
  def primeFactorMultiplicity(n: Int): List[(Int, Int)] =
    logger.debug(s"${n}")

    P35.primeFactors(n).groupBy(identity).view.mapValues(_.size).toList.sorted

end P36
