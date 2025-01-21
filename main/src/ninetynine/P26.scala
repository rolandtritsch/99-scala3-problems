package ninetynine

/** P26 - generate the combinations of k distinct objects chosen from the n elements of a list.
  */

object P26:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** Iterate over the list and remove one element at a time. Do this k times recursivly and keep
    * track on the elements that you take out. When you have recursed n times into it you need to
    * iterate over everything that is left over.
    *
    * @return
    *   the generated list of combinations
    */
  def combinations[A](k: Int, l: List[A]): List[List[A]] =
    if k == 0 then List(List())
    else if l.isEmpty then List()
    else
      // Take the first element and combine it with all combinations of k-1 elements from the rest
      // Or skip the first element and find all combinations of k elements from the rest
      combinations(k - 1, l.tail).map(l.head :: _) ++ combinations(k, l.tail)

  private def removeAtIndex[A](index: Int, l: List[A]): List[A] =
    val s = l.splitAt(index)
    s._1 ::: s._2.drop(1)

end P26
