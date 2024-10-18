package ninetynine

/** P01 - find the last element of the list.
  */

object P01 {
  final val logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

  /** Do a recursive pattern match to find last element of a list.
    *
    * @param l
    *   the list to process
    * @return
    *   the last element of the list l
    * @throws java.lang.RuntimeException
    *   when hitting unexpected case
    * @note
    *   asserts that list is not empty
    * @author
    *   roland@tritsch.email
    * @version 0.1.0
    * @since 0.1.0
    * @todo
    *   nothing
    */
  @annotation.tailrec
  final def last[A](l: List[A]): A = {
    assert(!l.isEmpty, "!l.isEmpty")
    logger.debug(s"${l}")

    l match {
      case e :: Nil  => e
      case _ :: rest => last(rest)
      case _         => throw new RuntimeException("Unexpected case")
    }
  }

  /** @deprecated("this method is deprecated", "0.1.0") */
  final def last_[A](l: List[A]): A = l.last
}
