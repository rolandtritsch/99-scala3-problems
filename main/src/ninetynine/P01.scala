package ninetynine

/** P01 - find last element of a list.
  */

object P01:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

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
  def last[A](l: List[A]): A =
    require(l.nonEmpty, "l.nonEmpty")
    logger.debug(s"${l}")

    l match
      case e :: Nil  => e
      case _ :: rest => last(rest)
      case _         => throw new RuntimeException("Unexpected case")

  end last

  /** @deprecated("this method is deprecated", "0.1.0") */
  def last_[A](l: List[A]): A = l.last

end P01
