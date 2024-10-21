package ninetynine

/** P37 - Goldbach's conjecture.
  */

object P37 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  def goldbach(n: Int): (Int, Int) = {
    logger.debug(s"${n}")

    val primes = LazyList.from(2).filter(P31.isPrime)
    primes.find(p => P31.isPrime(n - p)) match {
      case Some(p) => p -> (n - p)
      case None => throw new NoSuchElementException(s"No Goldbach composition found for $n")
    }
  }
}
