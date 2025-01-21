package ninetynine

/** P06 - find out if a list is a palindrome.
  */

object P06:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** @return true, if word w is a palindrom */
  def isPalindrom(w: String): Boolean =
    logger.debug(s"${w}")

    w.equals(P05.reverse(w.toList).mkString)

end P06
