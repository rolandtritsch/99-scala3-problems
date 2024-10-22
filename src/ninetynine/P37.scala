package ninetynine

/** P37 - Goldbach's conjecture.
  */

object P37 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  def goldbach(n: Int): (Int, Int) = {
    require(n > 2 && n % 2 == 0, "n must be greater than 2")
    logger.debug(s"${n}")

    val primes = LazyList.from(2).filter(P31.isPrime)
    val result = primes.find(p => P31.isPrime(n - p)) match {
      case Some(p) => p -> (n - p)
      case None => throw new NoSuchElementException(s"No Goldbach composition found for $n")
    }
    logger.debug(s"P37: ${n} -> ${result}")
    result
  }
}
