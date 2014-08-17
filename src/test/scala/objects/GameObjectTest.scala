package objects

import mechanics.Vec
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

class GameObjectTest extends AssertionsForJUnit {
  val objIn = new Square(200, 400)
  val objOut = new Square(1200, 800)
  val border = (800d, 600d)

  @Test
  def goThroughScreenCorrection = {
    objIn.goThroughScreenCorrection(border)
    objOut.goThroughScreenCorrection(border)
    assert(objIn.position == Vec(200, 400))
    assert(objOut.position == Vec(400, 200))
  }

  @Test
  def stayInCorrection = {
    objIn.stayInCorrection(border)
    objOut.stayInCorrection(border)
    assert(objIn.position == Vec(200, 400))
    assert(objOut.position == Vec(799, 599))
  }

  @Test
  def outOfBorder = {
    assert(objIn.insideBorder(border) == true, " | " + objIn + " is outside the " + border)
    assert(objOut.insideBorder(border) == false)
  }
}