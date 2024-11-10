package ninetynine

/** P35 Determine the prime factors of a given positive integer.
  */

object P35 {
  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return a flat list containing the prime factors in ascending order. */
  def primeFactors(n: Int): List[Int] = {
    logger.debug(s"${n}")

    @annotation.tailrec
    def primeFactors(n: Int, p: Int, pfs: List[Int]): List[Int] = {
      if (n < 2) pfs
      else if (n % p == 0) primeFactors(n / p, p, pfs ++ List(p))
      else primeFactors(n, p + 1, pfs)
    }
    primeFactors(n.abs, 2, List())
  }
}
