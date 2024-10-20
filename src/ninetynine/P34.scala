package ninetynine

/** P34 Calculate Euler's totient function phi(m).
  */

object P34 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return Eulers totient for n */
  def totient(n: Int): Int = {
    logger.debug(s"${n}")

    (1 to n).filter(P33.isCoprime(n, _)).length
  }
}
