object Problem111 {
  def main(args: Array[String]) {
    //println(sieveOfEratosthenes(100).toList.sorted)
    //println(getListOfPrimesWithLength(2))
    println(sumOfSFunctions(4))
    //for (i <- 0 to 9) println(sFunction(4, i))
  }

  def countRepeatedDigits(number: Int, digit: Int): Int = number.toString.count(_ == (digit + 48).toChar)

  def mFunction(primeLength: Int, digit: Int) = getMapOfPrimesWithMaxDigitsNumber(primeLength, digit)._1

  def nFunction(primeLength: Int, digit: Int): Int = getMapOfPrimesWithMaxDigitsNumber(primeLength, digit)._2.size

  def sFunction(primeLength: Int, digit: Int): BigInt = getMapOfPrimesWithMaxDigitsNumber(primeLength, digit)._2.sum

  def getMapOfPrimesWithMaxDigitsNumber(primeLength: Int, digit: Int): (Int, List[Int]) = {
    getListOfPrimesWithLength(primeLength).groupBy(x => countRepeatedDigits(x, digit)).maxBy(_._1)
  }

  def sumOfSFunctions(primeLength: Int): BigInt = (0 to 9).map(x => sFunction(primeLength, x)).sum

  def getListOfPrimesWithLength(length: Int): List[Int] = sieveOfEratosthenes(math.pow(10, length).toInt).filter(x => x >= math.pow(10, length - 1)).toList

  def sieveOfEratosthenes(nTo: Int) = {
    val primes = collection.mutable.BitSet.empty.par ++ (2 to nTo)
    for {
      candidate <- 2 to Math.sqrt(nTo).toInt
      if primes contains candidate
    } primes --= candidate * candidate to nTo by candidate
    primes
  }


/*
  import scala.annotation.tailrec

  def sieveOfEratosthenes(nTo: Int) = {
    val nonprimes: Array[Int] = new Array((nTo >>> 5) + 1)

    def cullp(p: Int) = {
      @tailrec def cull(c: Int): Unit = {
        if (c <= nTo) nonprimes(c >>> 5) |= 1 << (c & 31)
        cull(c + p)
      }
      cull(p * p)
    }

    def nextprime(i: Int): Int = {
      if (i > nTo) i else if ((nonprimes(i >>> 5) & (1 << (i & 31))) != 0) nextprime(i + 1) else i
    }

    for {
      p <- 2 to Math.sqrt(nTo).toInt
      if (nonprimes(p >>> 5).&(1 << (p & 31))) == 0
    } cullp(p)

    Iterator.iterate(2)(c => nextprime(c + 1)).takeWhile(_ <= nTo)
  }
*/

}
