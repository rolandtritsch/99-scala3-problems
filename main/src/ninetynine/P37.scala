package ninetynine

/** P37 - calculate Euler's totient function phi(m) (improved).
  *
  * Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <=
  * r < m) that are coprime to m. We let phi(1) = 1.
  *
  * From the definition of P34, we can see that phi(m) is equal to m * (1 - 1/p1) * (1 - 1/p2) * (1
  * \- 1/p3) * ... where p1, p2, p3, ... are the prime factors of m.
  *
  * Note that we need to use the primeFactors function from P36.
  */

object P37:
  val logger = com.typesafe.scalalogging.Logger(getClass)

  /** @return Euler's totient function phi(m) */
  def totient(m: Int): Int =
    require(m > 0, "m > 0")
    logger.debug(s"${m}")

    P36.primeFactorMultiplicity(m).foldLeft(1) { case (acc, (p, m)) =>
      acc * (p - 1) * math.pow(p, m - 1).toInt
    }

  end totient

end P37
