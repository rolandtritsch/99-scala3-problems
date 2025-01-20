package ninetynine

/** P19 - rotate a list N places to the left.
  */

object P19:
  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return the list l rotated N times to the left. */
  @annotation.tailrec
  def rotate[A](n: Int, l: List[A]): List[A] =
    logger.debug(s"${n} - ${l}")

    def rotateClockwise(l: List[A]): List[A] = l.tail ++ List(l.head)
    def rotateCounterClockwise(l: List[A]): List[A] = List(l.last) ++ l.init

    n match
      case 0          => l
      case _ if n > 0 => rotate(n - 1, rotateClockwise(l))
      case _ if n < 0 => rotate(n + 1, rotateCounterClockwise(l))

  end rotate

end P19
