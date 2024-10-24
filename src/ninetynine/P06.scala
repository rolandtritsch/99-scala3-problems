package ninetynine

/** P06 - find out if a word is a palindrom.
  */

object P06 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** @return true, if word w is a palindrom */
  final def isPalindrom(w: String): Boolean = {
    logger.debug(s"${w}")

    w.equals(P05.reverse(w.toList).mkString)
  }
}
