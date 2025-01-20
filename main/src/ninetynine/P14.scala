package ninetynine

import com.typesafe.scalalogging.Logger

/** P14 - duplicate the elements of a list.
  */

object P14:
  val logger: Logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  def duplicate[A](l: List[A]): List[A] =
    logger.debug(s"${l}")

    (for (e <- l) yield List(e, e)).flatten

end P14
