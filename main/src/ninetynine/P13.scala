package ninetynine

/** P13 - run-length encoding of a list (direct solution).
  */

object P13:
  val logger = com.typesafe.scalalogging.Logger(getClass)

  /** @return run-length encoded list */
  def encode[A](l: List[A]): List[(Int, A)] =
    logger.debug(s"${l}")

    def encode(rest: List[A], original: List[A]): List[(Int, A)] =
      val current = (original.count(rest.head == _), rest.head)
      if rest.size == 1 then List(current) else current :: encode(rest.tail, original)

    if l.isEmpty then List[(Int, A)]() else encode(l.distinct, l)

  end encode

end P13
