package ninetynine

/** P27 - group the elements of a set into disjoint subsets.
  */

object P27 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return 3 disjoint subgroups of 1, 2 and 3 elements */
  def group3[A](l: List[A]): List[List[List[A]]] = {
    logger.debug(s"${l}")

    for {
      a <- P26.combinations(1, l)
      noA = l.diff(a)
      b <- P26.combinations(2, noA)
      noB = noA.diff(b)
    } yield List(a, b, noB)
  }

  def group[A](ns: List[Int], l: List[A]): List[List[List[A]]] = {
    logger.debug(s"${ns} - ${l}")

    ns match {
      case Nil       => List(Nil)
      case n :: rest => P26.combinations(n, l).flatMap { c => {
        group(rest, l.diff(c)).map { c :: _ }
      }}
    }
  }
}
