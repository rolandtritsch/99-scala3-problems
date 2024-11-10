package ninetynine

/** P22 - create a list containing all integers within a given range.
  */

object P22 {
  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return a list with all integers from/to */
  def range(from: Int, to: Int): List[Int] = {
    require(to >= from, "to >= from")
    logger.debug(s"${from} - ${to}")

    List.fill(to - from)(1).foldLeft(List(from)) { (a, e) => {
      (a.head + e) :: a
    }}.reverse
  }
}
