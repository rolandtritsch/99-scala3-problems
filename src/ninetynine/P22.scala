package ninetynine

/** P22 - create a list containing all integers within a given range.
  */

object P22 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return a list with all integers from/to */
  final def range(from: Int, to: Int): List[Int] = {
    assert(to >= from, "to >= from")
    logger.debug(s"${from} - ${to}")

    List.fill(to - from)(1).foldLeft(List(from)) { (a, e) => {
      (a.head + e) :: a
    }}.reverse
  }
}
