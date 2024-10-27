package ninetynine

/** P34 Calculate [[https://en.wikipedia.org/wiki/Euler%27s_totient_function Euler's totient function]] phi(m).
  */

object P34 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return Eulers totient for n */
  def totient(n: Int): Int = {
    require(n >= 0, "n >= 0")
    logger.debug(s"${n}")

    (1 to n).count(P33.isCoprimeTo(n, _))
  }
}
