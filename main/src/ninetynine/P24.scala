package ninetynine

/** P24 - draw n different random numbers from the set 1..m.
  */

object P24:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** @return n out of rangeSize numbers (as a list) */
  def lotto(n: Int, rangeSize: Int): List[Int] =
    require(n >= 0 && n <= rangeSize, "n >= 0 && n <= rangeSize")
    logger.debug(s"${n} - ${rangeSize}")

    P23.randomSelect(n, P22.range(1, rangeSize))

  end lotto

end P24
