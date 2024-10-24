package ninetynine

import scala.util.Random

/** P23 - extract a given number of randomly selected elements
  * from a list.
  */

object P23 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return n randomly selected elements from l */ 
  final def randomSelect[A](n: Int, l: List[A]): List[A] = {
    require(n >= 0 && n <= l.size, "n >= 0 && n <= l.size")
    logger.debug(s"${n} - ${l}")

    if(l.size == n) l
    else randomSelect(n, P20.removeAt(Random.nextInt(l.size), l)._1)
  }
}
