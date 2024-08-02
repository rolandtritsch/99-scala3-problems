package ninetynine

/** P15 - duplicate the elements of a list a given number of times.
  */

object P15 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  final def duplicate[A](n: Int, l: List[A]): List[A] = {
    logger.debug(s"${l}")

    (for (e <- l) yield List.fill(n)(e)).flatten
  }
}
