package ninetynine

import org.scalacheck.Prop._

class P06Test extends munit.ScalaCheckSuite {
  property("P06 - palindrome") {
    assert(P06.isPalindrom("abba"))
    assert(P06.isPalindrom("racecar"))
    assert(P06.isPalindrom("madam"))
    assert(P06.isPalindrom("())("))
    assert(!P06.isPalindrom("()()"))

    forAll { (s: String) =>
      val palindrome = s + s.reverse
      assert(P06.isPalindrom(palindrome))
    }
  }
}
