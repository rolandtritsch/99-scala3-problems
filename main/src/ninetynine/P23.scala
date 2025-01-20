package ninetynine

// scalafix:off
import scala.util.Random

import com.typesafe.scalalogging.Logger
// scalafix:on

/** P23 - extract a given number of randomly selected elements from a list.
  */

object P23:
  val logger: Logger = Logger(this.getClass.getName)

  /** @return n randomly selected elements from l */
  def randomSelect[A](n: Int, l: List[A]): List[A] =
    require(n >= 0 && n <= l.size, "n >= 0 && n <= l.size")
    logger.debug(s"${n} - ${l}")

    if l.size == n then l else randomSelect(n, P20.removeAt(Random.nextInt(l.size), l)._1)

  end randomSelect

end P23
