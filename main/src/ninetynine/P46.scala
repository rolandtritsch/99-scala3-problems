package ninetynine

/** P46 - truth tables for logical expressions.
  */

object P46:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  def and(a: Boolean, b: Boolean): Boolean = a && b
  def or(a: Boolean, b: Boolean): Boolean = a || b
  def nand(a: Boolean, b: Boolean): Boolean = !and(a, b)
  def nor(a: Boolean, b: Boolean): Boolean = !or(a, b)
  def xor(a: Boolean, b: Boolean): Boolean = !equ(a, b)
  def impl(a: Boolean, b: Boolean): Boolean = or(!a, b)
  def equ(a: Boolean, b: Boolean): Boolean = a == b

  /** @return a list of truth tables */
  def table(f: (Boolean, Boolean) => Boolean): List[(Boolean, Boolean, Boolean)] = List(
    (true, true, f(true, true)),
    (true, false, f(true, false)),
    (false, true, f(false, true)),
    (false, false, f(false, false)),
  )

end P46
