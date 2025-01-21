package ninetynine

/** P12 - decode a run-length encoded list.
  */

object P12:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** @return run-length decoded list */
  def decode[A](l: List[(Int, A)]): List[A] =
    logger.debug(s"${l}")

    (for (i <- l; c = i._1; e = i._2) yield List.fill(c)(e)).flatten

end P12
