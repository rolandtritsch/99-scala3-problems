package ninetynine

import org.scalacheck.Prop._
import scala.util.Random

class P00Test extends munit.ScalaCheckSuite {
  val ignore = new munit.Tag("ignore")

  property("P01 - last") {
    val result = P01.last(List("first", "last"))
    val expected = "last"
    assertEquals(result, expected)

    forAll { (l: List[Int]) =>
      (l.nonEmpty) ==> (P01.last(l) == l.last)
    }
  }

  property("P02 - penultimate") {
    val result = P02.penultimate(List("first", "middle", "last"))
    val expected = "middle"
    assertEquals(result, expected)

    forAll { (l: List[Int]) =>
      (l.size >= 2) ==> (P02.penultimate(l) == l.take(l.size - 1).last)
    }
  }

  property("P03 - nth") {
    val result = P03.nth(2, List("first", "middle", "last"))
    val expected = "last"
    assertEquals(result, expected)

    forAll { (l: List[Int]) =>
      forAll { (n: Int) =>
        (n >= 0 && l.size - 1 >= n) ==> (P03.nth(n, l) == l(n))
      }
    }
  }

  property("P04 - size") {
    val result = P04.size(List("first", "middle", "last"))
    val expected = 3
    assertEquals(result, expected)

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
    assert(
      P07.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) == List(1, 1, 2, 3,
        5, 8)
    )

    forAll { (l: List[List[Int]]) =>
      P07.flatten(l) == l.flatten
    }
  }

  property("P08 - compress") {
    val result = P08.compress(
      List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    )
    val expected = List('a', 'b', 'c', 'd', 'e')
    assert(result.toSet == expected.toSet)

    forAll { (l: List[Int]) =>
      val ld = l.distinct
      val ll = ld ++ ld

      P08.compress(ll).toSet == l.toSet
    }
  }

  test("P09 - pack") {
    assert(
      P09.pack(
        List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e',
          'e')
      ) == List(
        List('a', 'a', 'a', 'a', 'a', 'a'),
        List('b'),
        List('c', 'c'),
        List('d'),
        List('e', 'e', 'e', 'e')
      )
    )
    assert(
      P09.pack(List(3, 1, 2, 3, 2, 3)).toSet == Set(
        List(1),
        List(2, 2),
        List(3, 3, 3)
      )
    )
  }

  test("P10 - encode") {
    assert(
      P10.encode(
        List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e',
          'e')
      ) == List((4, 'a'), (1, 'b'), (2, 'c'), (2, 'a'), (1, 'd'), (4, 'e'))
    )

    assert(
      P10.encode(List('a', 'c', 'c', 'c', 'b', 'b', 'a', 'b', 'b')) == List(
        (1, 'a'),
        (3, 'c'),
        (2, 'b'),
        (1, 'a'),
        (2, 'b')
      )
    )
  }

  test("P11 - encode") {
    assert(
      P11.encode(
        List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e',
          'e')
      ) == List((4, 'a'), 'b', (2, 'c'), (2, 'a'), 'd', (4, 'e'))
    )

    assert(
      P11.encode(
        List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e',
          'e')
      ) == List((4, 'a'), 'b', (2, 'c'), (2, 'a'), 'd', (4, 'e'))
    )
  }

  property("P12 - decode") {
    val result = P12.decode(
      List((4, 'a'), (1, 'b'), (2, 'c'), (2, 'a'), (1, 'd'), (4, 'e'))
    )
    val expected =
      List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    assertEquals(result, expected)

    forAll { (l: List[Int]) =>
      val ld = l.distinct
      val ll = ld ++ ld

      P12.decode(P10.encode(ll)) == ll
    }
  }

  test("P13 - encode") {
    val result = P13.encode(
      List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    )
    val expected = List((6, 'a'), (1, 'b'), (2, 'c'), (1, 'd'), (4, 'e'))
    assertEquals(result, expected)
  }

  property("P14 - duplicate") {
    val result = P14.duplicate(List('a', 'b', 'c', 'c', 'd'))
    val expected = List('a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'd', 'd')
    assertEquals(result, expected)

    forAll { (l: List[Int]) =>
      P14.duplicate(l) == l.foldLeft(List[Int]()) { (ll, e) =>
        {
          ll ++ List(e) ++ List(e)
        }
      }
    }
  }

  property("P15 - duplicate") {
    val result = P15.duplicate(2, List('a', 'b', 'c', 'c', 'd'))
    val expected = List('a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'd', 'd')
    assertEquals(result, expected)

    forAll { (l: List[Int]) =>
      P15.duplicate(3, l) == l.foldLeft(List[Int]()) { (ll, e) =>
        {
          ll ++ List(e) ++ List(e) ++ List(e)
        }
      }
    }
  }

  property("P16 - drop") {
    val result =
      P16.drop(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    val expected = List('a', 'b', 'd', 'e', 'g', 'h', 'j', 'k')
    assertEquals(result, expected)

    forAll { (l: List[Int]) =>
      P16.drop(3, l) == l.zipWithIndex.foldLeft(List[Int]()) { (ll, e) =>
        {
          if ((e._2 + 1) % 3 == 0) ll
          else ll ++ List(e._1)
        }
      }
    }
  }

  property("P17 - split") {
    val result =
      P17.split(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    val expected =
      (List('a', 'b', 'c'), List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    assertEquals(result, expected)

    forAll { (l: List[Int]) =>
      forAll { (n: Int) =>
        (l.size - 1 >= n) ==> (P17.split(n, l) == l.splitAt(n))
      }
    }
  }

  test("P18 - slice") {
    val result = P18.slice(
      3,
      7,
      List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    )
    val expected = List('d', 'e', 'f', 'g')
    assertEquals(result, expected)
  }

  property("P19 - rotate") {
    val result =
      P19.rotate(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
    val expected = List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'a', 'b', 'c')
    assertEquals(result, expected)

    forAll { (n: Int, l: List[Int]) =>
      (n >= 0 && l.size - 1 > n) ==> (P19.rotate(n, l) == {
        if (n >= 0) l.drop(n) ++ l.take(n)
        else l.drop(n + l.size) ++ l.take(n + l.size)
      })
    }
  }

  property("P20 - removeAt") {
    val result = P20.removeAt(1, List('a', 'b', 'c', 'd'))
    val expected = (List('a', 'c', 'd'), 'b')
    assertEquals(result, expected)

    forAll { (n: Int, l: List[Int]) =>
      (n >= 0 && l.size - 1 >= n) ==> (P20.removeAt(n, l) == {
        (l.slice(0, n) ++ l.slice(n + 1, l.size), l(n))
      })
    }
  }

  test("P21 - insertAt") {
    val result = P21.insertAt('x', 1, List('a', 'b', 'c', 'd'))
    val expected = List('a', 'x', 'b', 'c', 'd')
    assertEquals(result, expected)
  }

  // property("P22 - range".tag(ignore)) {
  property("P22 - range") {
    val result = P22.range(4, 9)
    val expected = List(4, 5, 6, 7, 8, 9)
    assertEquals(result, expected)

    forAll { (f: Short) =>
      val from = f.toInt
      val to = Random.between(from, from + 100)
      P22.range(from, to) == {
        Range(from, to + 1).toList
      }
    }
  }

  test("P23 - randomSelect") {
    val result = P23.randomSelect(3, List('a', 'b', 'c', 'd', 'f', 'g', 'h'))
    assert(result.size == 3)
  }

  test("P24 - lotto") {
    val result = P24.lotto(6, 49)
    assert(result.size == 6)
  }

  property("P25 - randomPermute") {
    val l = List('a', 'b', 'c', 'd', 'e', 'f')
    val result = P25.randomPermute(l)
    assertEquals(result.size, l.size)

    forAll { (l: List[Int]) =>
      P25.randomPermute(l).size == l.size
    }
  }

  test("P26 - combinations") {
    val result = P26.combinations(3, List('a', 'b', 'c', 'd', 'e'))
    assert(result.size == 60)
  }

  test("P27 - group3") {
    val result = P27.group3(
      List(
        "Aldo",
        "Beat",
        "Carla",
        "David",
        "Evi",
        "Flip",
        "Gary",
        "Hugo",
        "Ida"
      )
    )
    assert(result.flatten.flatten.flatten.size == 18144)
  }

  test("P27 - group") {
    val result = P27.group(
      List(2, 2, 5),
      List(
        "Aldo",
        "Beat",
        "Carla",
        "David",
        "Evi",
        "Flip",
        "Gary",
        "Hugo",
        "Ida"
      )
    )
    assert(result.flatten.flatten.flatten.size == 13063680)
  }

  test("P28 - lsort") {
    val input = List(
      List('a', 'b', 'c'),
      List('d', 'e'),
      List('f', 'g', 'h'),
      List('d', 'e'),
      List('i', 'j', 'k', 'l'),
      List('m', 'n'),
      List('o')
    )
    val result = P28.lsort(input)
    val expected = List(
      List('o'),
      List('d', 'e'),
      List('d', 'e'),
      List('m', 'n'),
      List('a', 'b', 'c'),
      List('f', 'g', 'h'),
      List('i', 'j', 'k', 'l')
    )

    assertEquals(result, expected)
  }

  test("P28 - lsortFreq - Char") {
    val input = List(
      List('a', 'b', 'c'),
      List('d', 'e'),
      List('f', 'g', 'h'),
      List('d', 'e'),
      List('i', 'j', 'k', 'l'),
      List('m', 'n'),
      List('o')
    )
    val result = P28.lsortFreq(input)
    val expected = List(
      List('i', 'j', 'k', 'l'),
      List('o'),
      List('a', 'b', 'c'),
      List('f', 'g', 'h'),
      List('d', 'e'),
      List('d', 'e'),
      List('m', 'n')
    )

    assertEquals(result, expected)
  }

  test("P28 - lsortFreq - Int") {
    val input = List(
      List(1, 2, 3),
      List(4, 5),
      List(6, 7, 8),
      List(4, 5),
      List(9, 10, 11, 12),
      List(13, 14),
      List(15)
    )
    val result = P28.lsortFreq(input)
    val expected = List(
      List(9, 10, 11, 12),
      List(15),
      List(1, 2, 3),
      List(6, 7, 8),
      List(4, 5),
      List(4, 5),
      List(13, 14)
    )

    assertEquals(result, expected)
  }

  property("P31 - isPrime") {
    import spire.math._
    import spire.math.SafeLong.apply

    forAll { (n: Int) =>
      (n > 1) ==> {
        assertEquals(P31.isPrime(n), n.isPrime)
      }
    }
  }

  property("P32 - gcd") {
    import spire.math._

    forAll { (a: Int, b: Int) =>
      assertEquals(P32.gcd(a, b), gcd(a, b).toInt)
    }
  }

  property("P33 - coprime") {
    import spire.math._

    forAll { (a: Int, b: Int) =>
      assertEquals(P33.isCoprime(a, b), gcd(a, b).toInt == 1)
    }
  }

  test("P34 - totient") {
    assertEquals(P34.totient(10), 4)
  }

  test("P35 - primeFactors") {
    assertEquals(P35.primeFactors(315), List(3, 3, 5, 7))

    import spire.math._
    import spire.math.SafeLong._

    (1 to 1000).foreach { n =>
      val result = P35.primeFactors(n)
      val expected = n.factor
        .flatMap { case (prime, exp) => List.fill(exp)(prime.toInt) }
        .toList
        .sorted
      assertEquals(result, expected)
    }
  }

  test("P36 - primeFactorMultiplicity") {
    assertEquals(P36.primeFactorMultiplicity(315), List((3, 2), (5, 1), (7, 1)))
    assertEquals(P36.primeFactorMultiplicity(100), List((2, 2), (5, 2)))
    assertEquals(P36.primeFactorMultiplicity(17), List((17, 1)))
    assertEquals(P36.primeFactorMultiplicity(1), List())

    import spire.math._
    import spire.math.SafeLong._

    (1 to 1000).foreach { n =>
      val result = P36.primeFactorMultiplicity(n)
      val expected = n.factor.map((p, e) => (p.toInt, e)).toList.sorted
      assertEquals(result, expected)
    }
  }

  property("P37 - goldbach") {
    assertEquals((5, 23), P37.goldbach(28))

    assertEquals((3, 7), P37.goldbach(10))
    assertEquals((3, 97), P37.goldbach(100))
    assertEquals((3, 5), P37.goldbach(8))
    assertEquals((5, 31), P37.goldbach(36))
    assertEquals((3, 89), P37.goldbach(92))

    assertEquals((17, 999983), P37.goldbach(1000000))
    assertEquals((7, 1048583), P37.goldbach(1048590))

    throws(classOf[IllegalArgumentException]) { P37.goldbach(2) }
    throws(classOf[IllegalArgumentException]) { P37.goldbach(3) }
    throws(classOf[IllegalArgumentException]) { P37.goldbach(-4) }
    /*
    forAll { (n: Int) =>
      (n > 2 && n % 2 == 0) ==> {
        assertEquals(P37.goldbach(n), goldbach(n))
      }
    }
    */
  }

  import spire.math.prime

  def goldbach(n: Int): (Int, Int) = {
    require(
      n > 2 && n % 2 == 0,
      "Input must be an even number greater than 2"
    )

    val primes = prime.lazyList.takeWhile(_ <= n / 2).map(_.toInt)

    val p = primes.find(pp => prime.isPrime(n - pp))
    val result =p match {
      case Some(ppp) => (ppp, n - ppp)
      case None =>
        throw new NoSuchElementException(
          s"No Goldbach composition found for $n"
        )
    }
    //println(s"${n} -> ${result}")
    result
  }

}
