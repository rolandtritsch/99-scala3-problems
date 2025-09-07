package ninetynine

/** P06 - find out if a list is a palindrome.
  */

object P06:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** @return true, if word w is a palindrom */
  def isPalindrom[A](l: List[A]): Boolean =
    logger.debug(s"l: ${l}")

    P05.reverse(l) == l

  def isPalindrom(w: String): Boolean = isPalindrom(w.toList)
  def isPalindrom(i: Int): Boolean = isPalindrom(i.toString)

end P06
