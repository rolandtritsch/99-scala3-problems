package ninetynine

/** P13 - Run-length encoding of a list (direct (recursive) solution).
  */

object P13 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return run-length encoded list */
  final def encode[A](l: List[A]): List[(Int, A)] = {
    logger.debug(s"${l}")

    def encode(rest: List[A], original: List[A]): List[(Int, A)] = {
      val current = (original.count(rest.head == _), rest.head)
      if (rest.size == 1) List(current)
      else current :: encode(rest.tail, original)
    }

    if (l.isEmpty) List[(Int, A)]()
    else encode(l.distinct, l)
  }
}
