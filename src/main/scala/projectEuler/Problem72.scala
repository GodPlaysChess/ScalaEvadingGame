package projectEuler

object Problem72 {
  val maxD = 1000000

  //00
  def solve() = {
    var counter = 0l
    for (i <- 2 to maxD) {
      counter += count(i)
      //      println(maxD)
            println(i)
    }
        println(counter)
  }

  def count(maxD: Int): Int = {
    (1 until maxD).count(x => gcd(x, maxD) == 1)
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
