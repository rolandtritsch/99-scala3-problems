package ninetynine

/** P19 - rotate a list N places to the left.
  */

object P19 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return the list l rotated N times to the left. */
  final def rotate[A](n: Int, l: List[A]): List[A] = {
    logger.debug(s"${n} - ${l}")

    def rotateOnce(l: List[A]): List[A] = l.tail ++ List(l.head)

    n match {
      case 0 => l
      case _ => rotate(n - 1, rotateOnce(l))
    }
  }
}
