package ninetynine

/** P34 - calculate Euler's totient function phi(m).
  */

object P34:
  val logger = com.typesafe.scalalogging.Logger(getClass)

  /** @return Eulers totient for n */
  def totient(n: Int): Int =
    require(n >= 0, "n >= 0")
    logger.debug(s"${n}")

    (1 to n).count(P33.isCoprimeTo(n, _))

  end totient

end P34
