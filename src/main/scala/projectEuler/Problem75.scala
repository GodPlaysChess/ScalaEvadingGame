package projectEuler

import scala.collection.mutable.ArrayBuffer

/**
 * Created by GlebP on 05-Sep-2014.
 */
object Problem75 extends Problem {

  val maxL = 100//000

  override def solve: Unit = {
    val c = smartTraverseThrough()
    println(c)
  }

  def smartTraverseThrough(): Long = {
    val seq: Array[Int] = new Array[Int](maxL)
    for (l <- 1 to maxL) {
      if (seq(l - 1) == 0) {
        val a = findABforL(l)
        if (a != 0) {
          (l to maxL).by(l).foreach(i => seq(i - 1) += 1)
        }
      }
    }
    var counter = 0
    for (x <- seq) {
      if (x == 1) counter +=1
    }
//    println("size = " + seq.filter(i => seq(i) == 1).size)
    println(seq.count(i => seq(i) == 1))
    println(seq)
    counter
  }

  def findABforL(l: Int): Int = {
//    println(l)
    for (a <- 1 to l / 3) {
      if ((l * l - 2 * a * l) % (2 * l - 2 * a) == 0) return a
    }

    0
  }

  //bruteforce 1835msec for 1500L. Answer: 288
  def bruteforce(): Int = {
    val q = for {
      l <- 3 to maxL
      c <- l / 3 to l / 2
      a <- 1 until c
      b = l - a - c
      if b <= a && a * a + b * b == c * c
    } yield {
      printf(" %d = %d + %d + %d \n ", l, c, a, b)
      l
    }
    println(q)
    q.toSet.size
  }

  def onlyOneTriangle(l: Int): Boolean = {
    var count = 0
    for {
      c <- l / 3 to l / 2
      a <- 1 until c
      b = l - a - c
      if b <= a && a * a + b * b == c * c
    } yield {
      printf(" %d = %d + %d + %d \n ", l, c, a, b)
      if (count == 1) return false
      count += 1
    }
    count == 1
  }

  //1663msec 161 for 1500
  def anotherBruteforce(): Int = {
    (4 to maxL).count(onlyOneTriangle)
  }

  //  def g: Int = {
  //    (3 to maxL).map(l => (1 to l / 3).flatMap(a => (1 to l / 3).flatMap(b => (1 to l / 3).filter(a * a + b * b == (l - a - b) * (l - a - b))))).count(x => x.size == 1)
  //  }


}
