package ninetynine

/** P49 - Gray code.
  */

object P49:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** @return the list of strings that represent the gray code for n */
  def gray(n: Int): List[String] =
    require(n >= 0, "n >= 0")
    logger.debug(s"${n}")

    val cache = scala.collection.mutable.Map[Int, List[String]]()

    def grayMemo(n: Int): List[String] =
      if cache.contains(n) then return cache(n) // scalafix:ok

      val result = n match
        case 1 => List("0", "1")
        case _ =>
          val prev = grayMemo(n - 1)
          val withZeros = prev.map("0" + _)
          val withOnes = prev.reverse.map("1" + _)
          withZeros ++ withOnes

      cache(n) = result
      result
    end grayMemo

    if n < 1 then List() else grayMemo(n)

  end gray

end P49
