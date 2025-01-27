package ninetynine

/** P00 - Template for new implementation files.
  */

object P00:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  /** @return the solution of the problem
    */
  def solution(): Int =
    logger.debug("Solution method called")
    0
