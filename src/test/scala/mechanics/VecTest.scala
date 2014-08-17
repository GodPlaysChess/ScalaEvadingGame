package mechanics

import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

class VecTest extends AssertionsForJUnit{

  @Test
  def modularDivision = {
    val a = Vec(100, 100)
    val b = Vec(200, 200)
    val c = Vec(300d, 200d)
    assert(a % b  == a)
    assert(a % c == a)
  }

  @Test
  def equals = {
    assert(Vec(100, 200) == Vec(100.0, 200))
  }

  @Test
  def sum = {
   assert(Vec(100 , 200) + Vec(200, 100) == Vec(300, 300))
  }

  @Test
  def abs = {
    assert(Vec(-100, 100).abs == Vec(100, 100))
    assert(Vec(-100, -100).abs == Vec(100, 100))
    assert(Vec(100, -100).abs == Vec(100, 100))
    assert(Vec(0, -100).abs == Vec(0, 100))
  }

}
