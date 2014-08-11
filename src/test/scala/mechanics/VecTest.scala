package mechanics

import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

class VecTest extends AssertionsForJUnit{

  @Test
  def modularDivision = {
    val a = Vec(100, 100)
    val b = Vec(200, 200)
    assert(a % b  == a)
  }

  @Test
  def equals = ???

  @Test
  def sum = ???


}
