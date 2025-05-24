package ninetynine

import P47.BooleanOperators

class P47Test extends munit.ScalaCheckSuite:

  import P47.not

  test("P47 - and operator"):
    val result = P47.table2((a: Boolean, b: Boolean) => a `and` b)
    val expected =
      List((true, true, true), (true, false, false), (false, true, false), (false, false, false))

    assertEquals(result, expected)

  test("P47 - or operator"):
    val result = P47.table2((a: Boolean, b: Boolean) => a `or` b)
    val expected =
      List((true, true, true), (true, false, true), (false, true, true), (false, false, false))

    assertEquals(result, expected)

  test("P47 - nand operator"):
    val result = P47.table2((a: Boolean, b: Boolean) => a `nand` b)
    val expected =
      List((true, true, false), (true, false, true), (false, true, true), (false, false, true))

    assertEquals(result, expected)

  test("P47 - nor operator"):
    val result = P47.table2((a: Boolean, b: Boolean) => a `nor` b)
    val expected =
      List((true, true, false), (true, false, false), (false, true, false), (false, false, true))

    assertEquals(result, expected)

  test("P47 - xor operator"):
    val result = P47.table2((a: Boolean, b: Boolean) => a `xor` b)
    val expected =
      List((true, true, false), (true, false, true), (false, true, true), (false, false, false))

    assertEquals(result, expected)

  test("P47 - impl operator"):
    val result = P47.table2((a: Boolean, b: Boolean) => a `impl` b)
    val expected =
      List((true, true, true), (true, false, false), (false, true, true), (false, false, true))

    assertEquals(result, expected)

  test("P47 - equ operator"):
    val result = P47.table2((a: Boolean, b: Boolean) => a `equ` b)
    val expected =
      List((true, true, true), (true, false, false), (false, true, false), (false, false, true))

    assertEquals(result, expected)

  test("P47 - complex expression"):
    val result = P47.table2((a: Boolean, b: Boolean) => a `and` (a `or` not(b)))
    val expected =
      List((true, true, true), (true, false, true), (false, true, false), (false, false, false))

    assertEquals(result, expected)

end P47Test