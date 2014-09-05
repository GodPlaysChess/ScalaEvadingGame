package projectEuler

import scala.collection.mutable.Set

object Problem72 {
  val maxD = 1000000
  val allNums : Array[Set[Int]] = null //(2 to maxD).map(x => Set(1 until x: _*)).toArray

  //00
  def solve() = {
    //    val c = smartcount()
    val c = count
    println(c)
  }

  // brute force - 3673 msec for 10K
  def count(): Int = {
    (2 to maxD)./:(0)((acc, d) => acc + (1 until d).count(n => gcd(n, d) == 1))
  }

  //  def smartcount(): Int = {
  //    ((1 to maxD) map fractions).sum
  //  }

  //  def fractions(d: Int): Int = {
  //        val numerators = Set(1 until d: _*)
  //        //    (1 until d).filter()
  //        for (i <- 1 until d) {
  //          if (numerators.contains(i)) {
  //            if (gcd(i, d) != 1) {
  //              numerators --= (i to d / i).by(i)
  //            }
  //          }
  //        }
  //        numerators.size
  //      }

  // yet 11457 msec   42msec
  def forfractions(): Int = {
    for {
      d <- 2 to maxD
      num <- 1 to d
    } yield {
      if (allNums(d - 2).contains(num) && gcd(num, d) != 1) {
        for (denom <- d to maxD by num) {
//          allNums(d - 2) -= x
          allNums(denom - 2) --= num to d by num
        }


//        println("removing " + (num to d by num) + " from " + (d))
      }
    }
    allNums.flatten.size
  }

  def main(args: Array[String]) = {
    val start = System.currentTimeMillis()
    solve()
    val finish = System.currentTimeMillis() - start
    println("took " + finish + " msec")
  }

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

}
