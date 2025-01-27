package ninetynine

class P31Test extends munit.ScalaCheckSuite:

  test("P31 - isPrime"):
    assert(P31.isPrime(2))
    assert(P31.isPrime(3))
    assert(!P31.isPrime(4))
    assert(P31.isPrime(5))
    assert(!P31.isPrime(6))
    assert(P31.isPrime(7))
    assert(!P31.isPrime(8))
    assert(P31.isPrime(11))
    assert(!P31.isPrime(12))
    assert(P31.isPrime(13))
    assert(!P31.isPrime(14))
    assert(P31.isPrime(17))
    assert(P31.isPrime(19))
    assert(!P31.isPrime(20))
    assert(P31.isPrime(23))

end P31Test
