package ninetynine

/** P21 - insert an element at a given position into a list.
  */

object P21 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return a new list with e inserted at position n into l */
  final def insertAt[A](e: A, n: Int, l: List[A]): List[A] = {
    logger.debug(s"${e} - ${n} - ${l}")

    val (head, tail) = l.splitAt(n)
    head ++ List(e) ++ tail
  }
}
