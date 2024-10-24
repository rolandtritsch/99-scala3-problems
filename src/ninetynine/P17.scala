package ninetynine

/** P17 - split a list into two parts.
  */

object P17 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return two lists that split l at position */
  final def split[A](n: Int, l: List[A]): (List[A], List[A]) = {
    require(l.size - 1 >= n, "l.size - 1 >= n")
    logger.debug(s"${l}")

    l.zipWithIndex.foldLeft(List[A](), List[A]()) { (ll, e) => {
      if (e._2 >= n) (ll._1, ll._2 ++ List(e._1))
      else (ll._1 ++ List(e._1), ll._2)
    }}
  }
}
