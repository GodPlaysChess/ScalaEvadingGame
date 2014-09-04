package projectEuler

import projectEuler.old.BigRational
import scala.collection.mutable.Set

object Problem73 {
  val lowLimit = new BigRational(1, 3)
  val hiLimit = new BigRational(1, 2)
  val maxD = 12000

  def highLimitNumeratorForD(d: Int): Int = if (d % 2 == 0) d / 2 - 1 else d / 2

  def lowLimitNumeratorForD(d: Int): Int = d / 3 + 1

  def fractionsInRange(d: Int): Set[BigRational] = {
    val fractions: Set[BigRational] = Set()
    val lowLimNum = lowLimitNumeratorForD(d)
    val hiLimNum = highLimitNumeratorForD(d)
    var numerator = hiLimNum
    while (numerator >= lowLimNum && numerator > 0) {
      fractions += new BigRational(numerator, d)
//      println("adding " + numerator + "/" + d)
      numerator -= 1

    }
    println(d + " | " + fractions.size)
    fractions
  }

  def solve() = {
//    val size = (1 to maxD).foldLeft(Set[BigRational]())((acc, x) => acc ++ fractionsInRange(x)).size
    val result = Set[BigRational]()
    for (i <- 1 to maxD) {
      result ++= fractionsInRange(i)

    }
//    val size = (1 to maxD flatMap fractionsInRange).c
    println(result.size)
  }

  def main(args: Array[String]) {
    val start = System.currentTimeMillis()
    solve()
    val finish = System.currentTimeMillis() - start
    println("took " + finish + " msec")
  }


}
