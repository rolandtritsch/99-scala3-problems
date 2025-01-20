package ninetynine

import com.typesafe.scalalogging.Logger

/** P09 - pack dublicates into sublists.
  */

object P09:
  val logger: Logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return a list of lists (packing dups into lists) */
  def pack[A](l: List[A]): List[List[A]] =
    logger.debug(s"${l}")

    for (i <- l.distinct) yield l.filter(_ == i)

end P09
