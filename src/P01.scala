package ninetynine

/** P01 - return the last element of the list.
  */

object P01 {
  final def last[T](l: List[T]): T = {
    assert(!l.isEmpty, "!l.isEmpty")

    l match {
      case e :: Nil  => e
      case _ :: rest => last(rest)
      case _         => throw new RuntimeException("Unexpected case")
    }
  }
}
