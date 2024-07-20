package ninetynine

import org.scalacheck.Prop._

class P00Test extends munit.ScalaCheckSuite {
  property("P01 - last") {
    forAll { (l: List[Int]) =>
      l.nonEmpty ==> (P01.last(l) == l.last)
    }
  }

  property("P02 - penultimate") {
    forAll { (l: List[Int]) =>
      (l.size >= 2) ==> (P02.penultimate(l) == l.take(l.size - 1).last)
    }
  }

  property("P03 - nth") {
    forAll { (n: Int, l: List[Int]) =>
      (n >= 0 && l.size - 1 >= n) ==> (P03.nth(n, l) == l(n))
    }
  }

  property("P04 - size") {
    forAll { (l: List[Int]) =>
      P04.size(l) == l.size
    }
  }

  property("P05 - reverse") {
    forAll { (l: List[Int]) =>
      P05.reverse(l) == l.reverse
    }
  }

  test("P06 - palindrome") {
    assert(P06.isPalindrom("())("))
    assert(!P06.isPalindrom("()()"))
    assert(P06.isPalindrom("abba"))
    assert(P06.isPalindrom("racecar"))
  }

  property("P07 - nested") {
    assert(P07.flatten(List(List(1, 2), 3)) == List(1, 2, 3))
    assert(P07.flatten(List(List(1, 2), List(3, 4))) == List(1, 2, 3, 4))
    assert(P07.flatten(List(List(1, List(2)), List(3, 4))) == List(1, 2, 3, 4))

    forAll { (l: List[List[Int]]) =>
      P07.flatten(l) == l.flatten
    }
  }

  property("P08 - compress") {
    forAll { (l: List[Int]) =>
      val ld = l.distinct
      val ll = ld ++ ld

      P08.compress(ll).toSet == l.toSet
    }
  }
}
