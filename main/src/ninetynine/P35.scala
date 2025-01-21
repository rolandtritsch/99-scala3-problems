package ninetynine

/** P35 - determine the prime factors of a given positive integer.
  */

object P35:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** @return a flat list containing the prime factors in ascending order. */
  def primeFactors(n: Int): List[Int] =
    logger.debug(s"${n}")

    @annotation.tailrec
    def primeFactors(n: Int, p: Int, pfs: List[Int]): List[Int] =
      if n < 2 then pfs
      else if n % p == 0 then primeFactors(n / p, p, pfs ++ List(p))
      else primeFactors(n, p + 1, pfs)
    primeFactors(n.abs, 2, List())

  end primeFactors

end P35
