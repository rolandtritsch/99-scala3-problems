package ninetynine

/** P57 - Binary search trees (dictionaries).
  */

object P57:

  import ninetynine.P55.*
  import ninetynine.P56.*

  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  extension [T: Ordering](tree: Tree[T])

    def addValue(value: T): Tree[T] = tree match
      case End => Node(value, End, End)
      case Node(v, left, right) =>
        if summon[Ordering[T]].lt(value, v) then Node(v, left.addValue(value), right)
        else Node(v, left, right.addValue(value))

end P57
