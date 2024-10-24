package ninetynine

/** P03 - find Nth element of a list.
  */

object P03 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return the Nth element of the list l */
  @annotation.tailrec
  final def nth[A](n: Int, l: List[A]): A = {
    require(n >= 0, "n >= 0")
    require(l.size - 1 >= n, "l.size - 1 >= n")
    logger.debug(s"${n} - ${l}")

    l match {
      case e :: _ if n == 0 => e
      case _ :: rest        => nth(n - 1, rest)
      case _                => throw new RuntimeException("Unexpected case")
    }
  }
}
