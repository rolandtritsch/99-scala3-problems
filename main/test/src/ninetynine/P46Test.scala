package ninetynine

class P46Test extends munit.ScalaCheckSuite:

  test("P46 - and"):
    val result = P46.table(P46.and)
    val expected =
      List((true, true, true), (true, false, false), (false, true, false), (false, false, false))

    assertEquals(result, expected)

  test("P46 - or"):
    val result = P46.table(P46.or)
    val expected =
      List((true, true, true), (true, false, true), (false, true, true), (false, false, false))

    assertEquals(result, expected)

  test("P46 - nand"):
    val result = P46.table(P46.nand)
    val expected =
      List((true, true, false), (true, false, true), (false, true, true), (false, false, true))

    assertEquals(result, expected)

  test("P46 - nor"):
    val result = P46.table(P46.nor)
    val expected =
      List((true, true, false), (true, false, false), (false, true, false), (false, false, true))

    assertEquals(result, expected)

  test("P46 - xor"):
    val result = P46.table(P46.xor)
    val expected =
      List((true, true, false), (true, false, true), (false, true, true), (false, false, false))

    assertEquals(result, expected)

  test("P46 - impl"):
    val result = P46.table(P46.impl)
    val expected =
      List((true, true, true), (true, false, false), (false, true, true), (false, false, true))

    assertEquals(result, expected)

  test("P46 - equ"):
    val result = P46.table(P46.equ)
    val expected =
      List((true, true, true), (true, false, false), (false, true, false), (false, false, true))
      
    assertEquals(result, expected)

end P46Test
