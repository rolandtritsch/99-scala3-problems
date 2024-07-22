package ninetynine

import org.scalacheck.Prop._
import scala.language.experimental

class P00Test extends munit.ScalaCheckSuite {
  property("P01 - last") {
    val result = P01.last(List("first", "last"))
    val expected = "last"
    assert(result == expected)

    forAll { (l: List[Int]) =>
      (l.nonEmpty) ==> (P01.last(l) == l.last)
    }
  }

  property("P02 - penultimate") {
    val result = P02.penultimate(List("first", "middle", "last"))
    val expected = "middle"
    assert(result == expected)

    forAll { (l: List[Int]) =>
      (l.size >= 2) ==> (P02.penultimate(l) == l.take(l.size - 1).last)
    }
  }

  property("P03 - nth") {
    val result = P03.nth(2, List("first", "middle", "last"))
    val expected = "last"
    assert(result == expected)

    forAll { (l: List[Int]) =>
      forAll { (n: Int) =>
        (n >= 0 && l.size - 1 >= n) ==> (P03.nth(n, l) == l(n))
      }
    }
  }

  property("P04 - size") {
    val result = P04.size(List("first", "middle", "last"))
    val expected = 3
    assert(result == expected)

    forAll { (l: List[Int]) =>
      P04.size(l) == l.size
    }
  }

  property("P05 - reverse") {
    val original = List("This", "is", "a", "test")
    val reverse = List("test", "a", "is", "This")

    assert(P05.reverse(original) == reverse)
    assert(P05.reverse(reverse) == original)

    forAll { (l: List[Int]) =>
      P05.reverse(l) == l.reverse
    }
  }

  test("P06 - palindrome") {
    assert(P06.isPalindrom("abba"))
    assert(P06.isPalindrom("racecar"))
    assert(P06.isPalindrom("())("))
    assert(!P06.isPalindrom("()()"))
  }

  property("P07 - nested") {
    assert(P07.flatten(List(List(1, 2), 3)) == List(1, 2, 3))
    assert(P07.flatten(List(List(1, 2), List(3, 4))) == List(1, 2, 3, 4))
    assert(P07.flatten(List(List(1, List(2)), List(3, 4))) == List(1, 2, 3, 4))
    assert(P07.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) == List(1, 1, 2, 3, 5, 8))

    forAll { (l: List[List[Int]]) =>
      P07.flatten(l) == l.flatten
    }
  }

  property("P08 - compress") {
    val result = P08.compress(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
    val expected = List('a', 'b', 'c', 'd', 'e')
    assert(result.toSet == expected.toSet)

    forAll { (l: List[Int]) =>
      val ld = l.distinct
      val ll = ld ++ ld

      P08.compress(ll).toSet == l.toSet
    }
  }

  test("P09 - pack") {
    assert(P09.pack(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')) == List(List('a', 'a', 'a', 'a', 'a', 'a'), List('b'), List('c', 'c'), List('d'), List('e', 'e', 'e', 'e')))
    assert(P09.pack(List(3, 1, 2, 3, 2, 3)).toSet == Set(List(1), List(2, 2), List(3, 3, 3)))
  }

  test("P10 - encode") {
    assert(P10.encode(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')) == List((4, 'a'), (1, 'b'), (2, 'c'), (2, 'a'), (1, 'd'), (4, 'e')))

    assert(P10.encode(List('a', 'c', 'c', 'c', 'b', 'b', 'a', 'b', 'b')) == List((1, 'a'), (3, 'c'), (2, 'b'), (1, 'a'), (2, 'b')))
  }

  test("P11 - encode") {
    assert(P11.encode(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')) == List((4, 'a'), 'b', (2, 'c'), (2, 'a'), 'd', (4, 'e')))

    assert(P11.encode(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')) == List((4, 'a'), 'b', (2, 'c'), (2, 'a'), 'd', (4, 'e')))
  }

  property("P12 - decode") {
    val result = P12.decode(List((4, 'a'), (1, 'b'), (2, 'c'), (2, 'a'), (1, 'd'), (4, 'e')))
    val expected = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    assert(result == expected)

    forAll { (l: List[Int]) =>
      val ld = l.distinct
      val ll = ld ++ ld

      P12.decode(P10.encode(ll)) == ll
    }
  }

  test("P13 - encode") {
    val result = P13.encode(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
    val expected = List((6, 'a'), (1, 'b'), (2, 'c'), (1, 'd'), (4, 'e'))
    assert(result == expected)
  }

  property("P14 - duplicate") {
    val result = P14.duplicate(List('a', 'b', 'c', 'c', 'd'))
    val expected = List('a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'd', 'd')
    assert(result == expected)

    forAll { (l: List[Int]) =>
      P14.duplicate(l) == l.foldLeft(List[Int]()) { (ll, e) => {
        ll ++ List(e) ++ List(e)
      }}
    }
  }

  property("P15 - duplicate") {
    val result = P15.duplicate(2, List('a', 'b', 'c', 'c', 'd'))
    val expected = List('a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'd', 'd')
    assert(result == expected)

    forAll { (l: List[Int]) =>
      P15.duplicate(3, l) == l.foldLeft(List[Int]()) { (ll, e) => {
        ll ++ List(e) ++ List(e) ++ List(e)
      }}
    }
  }

  property("P16 - drop") {
    val result = P16.drop(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    val expected = List('a', 'b', 'd', 'e', 'g', 'h', 'j', 'k')
    assert(result == expected)

    forAll { (l: List[Int]) =>
      P16.drop(3, l) == l.zipWithIndex.foldLeft(List[Int]()) { (ll, e) => {
        if ((e._2+1)%3 == 0) ll
        else ll ++ List(e._1)
      }}
    }
  }

  property("P17 - split") {
    val result = P17.split(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    val expected = (List('a', 'b', 'c'), List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    assert(result == expected)

    forAll { (l: List[Int]) =>
      forAll { (n: Int) =>
        (l.size - 1 >= n) ==> (P17.split(n, l) == l.splitAt(n))
      }
    }
  }

  test("P18 - slice") {
    val result = P18.slice(3, 7, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    val expected = List('d', 'e', 'f', 'g')
    assert(result == expected)
  }

  property("P19 - rotate") {
    val result = P19.rotate(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    val expected = List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'a', 'b', 'c')
    assert(result == expected)

    forAll { (n: Int, l: List[Int]) =>
      (n >= 0 && l.size - 1 > n) ==> (P19.rotate(n, l) == {
        if(n >= 0) l.drop(n) ++ l.take(n)
        else l.drop(n + l.size) ++ l.take(n + l.size)
      })
    }
  }

  property("P20 - removeAt") {
    val result = P20.removeAt(1, List('a', 'b', 'c', 'd'))
    val expected = (List('a', 'c', 'd'), 'b')
    assert(result == expected)

    forAll { (n: Int, l: List[Int]) =>
      (n >= 0 && l.size - 1 >= n) ==> (P20.removeAt(n, l) == {
        (l.slice(0, n) ++ l.slice(n + 1, l.size), l(n)) 
      })
    }
  }

  test("P21 - insertAt") {
    val result = P21.insertAt('x', 1, List('a', 'b', 'c', 'd'))
    val expected = List('a', 'x', 'b', 'c', 'd')
    assert(result == expected)
  }
}
