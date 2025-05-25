package ninetynine

/** P47 - Truth tables for logical expressions (2).
  *
  * Continue problem P46 by redefining and, or, etc as operators. (i.e. make them methods of a new
  * class with an implicit conversion from Boolean.) not will have to be left as a object method.
  */

object P47:
  val logger = com.typesafe.scalalogging.Logger(getClass) // scalafix:ok

  def not(a: Boolean): Boolean = !a

  /** A class that wraps Boolean and provides logical operations as methods */
  implicit class BooleanOperators(val a: Boolean):
    infix def and(b: Boolean): Boolean = a && b
    infix def or(b: Boolean): Boolean = a || b
    infix def nand(b: Boolean): Boolean = !(a && b)
    infix def nor(b: Boolean): Boolean = !(a || b)
    infix def xor(b: Boolean): Boolean = a != b
    infix def impl(b: Boolean): Boolean = !a || b
    infix def equ(b: Boolean): Boolean = a == b
  end BooleanOperators

  /** @return a list of truth tables */
  def table2(f: (Boolean, Boolean) => Boolean): List[(Boolean, Boolean, Boolean)] = List(
    (true, true, f(true, true)),
    (true, false, f(true, false)),
    (false, true, f(false, true)),
    (false, false, f(false, false)),
  )

end P47
