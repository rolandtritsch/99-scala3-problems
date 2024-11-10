package ninetynine

/** P14 - duplicate the elements of a list.
  */

object P14 {
  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  def duplicate[A](l: List[A]): List[A] = {
    logger.debug(s"${l}")

    (for (e <- l) yield List(e, e)).flatten
  }
}
