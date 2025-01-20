package ninetynine

import com.typesafe.scalalogging.Logger

/** P01 - find the last element of the list.
  */

object P01:
  val logger: Logger = com.typesafe.scalalogging.Logger(this.getClass.getName)

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
    require(l.nonEmpty, "!l.isEmpty")
    logger.debug(s"${l}")

    l match
      case e :: Nil  => e
      case _ :: rest => last(rest)
      case _         => throw new RuntimeException("Unexpected case")

  end last

  /** @deprecated("this method is deprecated", "0.1.0") */
  def last_[A](l: List[A]): A = l.last

end P01
