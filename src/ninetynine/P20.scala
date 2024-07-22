package ninetynine

/** P20 - remove the Nth element from a list (index on 0)
  */

object P20 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return the list l without the element on position n */
  final def removeAt[A](n: Int, l: List[A]): (List[A], A) = {
    logger.debug(s"${n} - ${l}")

    (l.zipWithIndex.foldLeft(List[A]()) { (ll, e) => {
      val (ee, ii) = e
      if (n == ii) ll
      else ll ++ List(ee)
    }}, l(n))
  }
}
