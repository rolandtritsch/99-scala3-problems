package ninetynine

/** P24 - Lotto: Draw N different random numbers from the set 1..M.
  */

object P24 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return n out of rangeSize numbers (as a list) */
  final def lotto(n: Int, rangeSize: Int): List[Int] = {
    require(n >= 0 && n <= rangeSize, "n >= 0 && n <= rangeSize")
    logger.debug(s"${n} - ${rangeSize}")

    P23.randomSelect(n, P22.range(1, rangeSize))
  }
}
