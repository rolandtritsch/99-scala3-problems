package ninetynine

/** P20 - remove the Nth element from a list (index on 0)
  */

object P20 {
  val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return the list l without the element on position n */
  def removeAt[A](n: Int, l: List[A]): (List[A], A) = {
    require(n >= 0 && n < l.size, "n >= 0 && n < l.size")
    require(!l.isEmpty, "!l.isEmpty")
    logger.debug(s"${n} - ${l}")

    val removed = l.zipWithIndex.foldLeft(List[A]()) { (ll, e) => {
      val (ee, ii) = e
      if (n == ii) ll
      else ll ++ List(ee)
    }}
    (removed, l(n))
  }
}
