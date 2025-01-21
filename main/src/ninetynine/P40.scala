package ninetynine

/** P40 - Goldbach's conjecture.
  *
  * Goldbach’s conjecture says that every positive even number greater than 2 is the sum of two
  * prime numbers. E.g. 28 = 5 + 23. It is one of the most famous facts in number theory that has
  * not been proved to be correct in the general case. It has been numerically confirmed up to very
  * large numbers (much larger than Scala’s Int can represent).
  */

object P40:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** @return a Goldbach composition */
  def goldbach(n: Int): (Int, Int) =
    require(n > 2 && isEven(n), "n > 2 && isEven(n)")
    logger.debug(s"${n}")

    val primes = LazyList.from(2).filter(P31.isPrime)
    primes.find(pCurrent => P31.isPrime(n - pCurrent)) match
      case Some(pFound) => (pFound, (n - pFound))
      case None         => throw new RuntimeException("Unexpected case")

  end goldbach

  /** @return true if n is even */
  def isEven(n: Int): Boolean = n % 2 == 0

end P40
