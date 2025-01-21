package ninetynine

/** P41 - a list of Goldbach compositions.
  */

object P41:
  val logger = com.typesafe.scalalogging.Logger(getClass)

  /** @return a list of Goldbach compositions */
  def goldbachList(r: Range): List[(Int, Int)] =
    require(r.start >= 2 && P40.isEven(r.start), "r.start >= 2 && isEven(r.start)")
    require(r.end >= r.start && P40.isEven(r.end), "r.end >= r.start && isEven(r.end)")
    logger.debug(s"${r}")

    r.withFilter(P40.isEven).map(P40.goldbach).toList

  end goldbachList

  /** @return
    *   a list of Goldbach compositions with the first element of the pair greater than limit
    */
  def goldbachListLimited(r: Range, limit: Int): List[(Int, Int)] =
    require(limit >= 2, "limit >= 2")
    logger.debug(s"${r} - ${limit}")

    goldbachList(r).filter((p, _) => p > limit)

  end goldbachListLimited

end P41
