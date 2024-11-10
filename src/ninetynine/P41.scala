package ninetynine

/** P41 - A list of Goldbach compositions.
  */

object P41 {
  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return a list of Goldbach compositions */
  def goldbachList(n: Int, m: Int): List[(Int, Int)] = {
    require(n > 2 && P40.isEven(n), "n > 2 && isEven(n)")
    require(m >= n && P40.isEven(m), "m >= n && isEven(m)")

    logger.debug(s"${n} -${m}")

    (n to m)
      .filter(x => P40.isEven(x))
      .map(P40.goldbach)
      .map {
        case (a, b) if a > b => (b, a)
        case pair            => pair
      }
      .sortBy(_._1)
      .toList
  }
}
