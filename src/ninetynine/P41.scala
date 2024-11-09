package ninetynine

/** P41 - A list of Goldbach compositions.
    *
    * @param n
    *   the number to process
    * @return
    *   a list of Goldbach compositions
    * @throws java.lang.RuntimeException
    *   when hitting unexpected case
    * @note
    *   asserts that n is even
    * @author
    *   roland@tritsch.email
  ` * @version 0.1.0
    * @since 0.1.0
    * @todo
    *   nothing
  */

object P41 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return a list of Goldbach compositions */
  final def goldbachList(n: Int, m: Int): List[(Int, Int)] = {
      require(n > 2, "n > 2")
      require(m > 2, "m > 2")
      require(n % 2 == 0, "n % 2 == 0")
      require(m % 2 == 0, "m % 2 == 0")

      logger.debug(s"${n} -${m}")

      (n to m).filter(_ % 2 == 0).map(P40.goldbach).toList
  }
}