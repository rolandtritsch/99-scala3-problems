package ninetynine

/** P41 - A list of Goldbach compositions.
  */

object P41 {
  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return a list of Goldbach compositions */
  def goldbachList(r: Range): List[(Int, Int)] = {
    require(r.start > 2 && P40.isEven(r.start), "r.start > 2 && isEven(r.start)")
    require(r.end >= r.start && P40.isEven(r.end), "r.end >= r.start && isEven(r.end)")

    logger.debug(s"${r}")

    r.filter(x => P40.isEven(x)).map(P40.goldbach).toList
  }

  def goldbachListLimited(r: Range, limit: Int): List[(Int, Int)] = {
    require(limit > 2, "limit > 2")

    logger.debug(s"${r} - ${limit}")

    goldbachList(r).filter(c => c._1 > limit)
  }  
}
