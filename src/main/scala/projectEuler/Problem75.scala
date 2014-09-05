package projectEuler

/**
 * Created by GlebP on 05-Sep-2014.
 */
object Problem75 extends Problem {

  val maxL = 1500 //1500000

  override def solve: Unit = {
    println(anotherBruteforce())
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
//      printf(" %d = %d + %d + %d \n ", l, c, a, b)
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
