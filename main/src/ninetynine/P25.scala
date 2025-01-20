package ninetynine

import scala.util.Random

import com.typesafe.scalalogging.Logger

/** P25 - generate a random permutation of the elements of a list.
  */

object P25:
  val logger: Logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return a random shuffle of list l */
  def randomPermute[A](l: List[A]): List[A] =
    logger.debug(s"${l}")

    if l.size >= 2 then
      val next = P20.removeAt(Random.nextInt(l.size), l)
      next._2 +: randomPermute(next._1)
    else l

  end randomPermute

end P25
