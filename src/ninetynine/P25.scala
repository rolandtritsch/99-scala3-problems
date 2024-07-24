package ninetynine

import scala.util.Random

/** P25 - generate a random permutation of the elements of a list.
  */

object P25 {
  final val logger = com.typesafe.scalalogging.Logger(getClass.getName)

  /** @return a random shuffle of list l */
  final def randomPermute[A](l: List[A]): List[A] = {
    logger.debug(s"${l}")

    if(l.size >= 2) {
      val next = P20.removeAt(Random.nextInt(l.size), l)
      next._2 +: randomPermute(next._1)
    }
    else l
  }
}
