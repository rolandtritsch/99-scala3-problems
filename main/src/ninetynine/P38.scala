package ninetynine

/** P38 - Compare the two methods of calculating Euler's totient function.
  *
  * Use the solutions of problems P34 and P37 to compare the algorithms.
  * Try to calculate phi(10090) as an example.
  */

object P38:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** Compare the performance of the two totient functions and return results
    *
    * @param n
    *   the number to calculate the totient for
    * @return
    *   a tuple containing both results and their execution times in nanoseconds
    */
  def compareTotient(n: Int): ((Int, Long), (Int, Long)) =
    require(n > 0, "n > 0")
    logger.debug(s"${n}")

    val startTime1 = System.nanoTime()
    val phi1 = P34.totient(n)
    val duration1 = System.nanoTime() - startTime1

    val startTime2 = System.nanoTime()
    val phi2 = P37.totient(n)
    val duration2 = System.nanoTime() - startTime2

    ((phi1, duration1), (phi2, duration2))

  /** Calculate how much faster the P37 implementation is compared to P34
    *
    * @param n
    *   the number to calculate the totient for
    * @return
    *   the speedup factor (P34 time / P37 time)
    */
  def speedup(n: Int): Double =
    val ((_, time1), (_, time2)) = compareTotient(n)
    time1.toDouble / time2.toDouble

end P38