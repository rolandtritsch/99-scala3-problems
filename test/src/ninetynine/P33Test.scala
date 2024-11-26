package ninetynine

class P33Test extends munit.ScalaCheckSuite {
  test("P33 - isCoprimeTo") {
    assert(P33.isCoprimeTo(35, 64))
    assert(!P33.isCoprimeTo(36, 63))
  }
}
