package ninetynine

import org.scalacheck.Prop.*

class P06Test extends munit.ScalaCheckSuite:

  property("P06 - palindrome"):
    assert(P06.isPalindrom(""))
    assert(P06.isPalindrom(" "))
    assert(!P06.isPalindrom("xyz"))

    assert(P06.isPalindrom("abba"))
    assert(P06.isPalindrom("racecar"))
    assert(P06.isPalindrom("madam"))

    assert(P06.isPalindrom("())("))
    assert(!P06.isPalindrom("()()"))

    assert(P06.isPalindrom(List(1, 2, 1)))
    assert(P06.isPalindrom(123321))

    forAll: (s: String) =>
      val palindrome = s + s.reverse
      P06.isPalindrom(palindrome)

end P06Test
