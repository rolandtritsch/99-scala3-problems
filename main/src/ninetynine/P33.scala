package ninetynine

/** P33 - determine whether two positive integer numbers are coprime.
  */

object P33:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** @return true if the two numbers are coprime. */
  def isCoprimeTo(a: Int, b: Int): Boolean =
    logger.debug(s"${a} - ${b}")

    P32.gcd(a, b) == 1

end P33
