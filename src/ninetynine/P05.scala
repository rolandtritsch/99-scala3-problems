package ninetynine

/** P05 - reverse a list.
  */

object P05 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return the reverse of the list l */
  final def reverse[A](l: List[A]): List[A] = {
    logger.debug("${l}")

    @annotation.tailrec
    def reverse[A](l: List[A], r: List[A]): List[A] = {
      l match {
        case Nil       => r
        case e :: rest => reverse(rest, e :: r)
      }
    }
    reverse(l, List())
  }
}
