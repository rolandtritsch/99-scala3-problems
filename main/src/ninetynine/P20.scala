package ninetynine

/** P20 - remove the kth element from a list.
  */

object P20:
  val logger = com.typesafe.scalalogging.Logger(getClass)

  /** @return the list l without the element on position n */
  def removeAt[A](n: Int, l: List[A]): (List[A], A) =
    require(n >= 0 && n < l.size, "n >= 0 && n < l.size")
    require(l.nonEmpty, "!l.isEmpty")
    logger.debug(s"${n} - ${l}")

    val removed = l.zipWithIndex.foldLeft(List[A]()) { (ll, e) =>
      val (ee, ii) = e
      if n == ii then ll else ll ++ List(ee)
    }
    (removed, l(n))

  end removeAt

end P20
