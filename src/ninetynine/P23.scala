package ninetynine

import scala.util.Random

/** P23 - extract a given number of randomly selected elements from a
  * list.
  */

object P23 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return n randomly selected elements from l */ 
  final def randomSelect[A](n: Int, l: List[A]): List[A] = {
    if(l.size == n) l
    else randomSelect(n, P20.removeAt(Random.nextInt(l.size), l)._1)
  }
}
