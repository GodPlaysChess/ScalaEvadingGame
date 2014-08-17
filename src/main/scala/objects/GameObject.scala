package objects

import mechanics.Vec
import utilities.Logging

abstract class GameObject(var position: Vec, var forRemove: Boolean = false) extends Logging {

  logger.info("Creating " + toString)

  def size: Double

  def draw(): Unit

  def update(delta: Double, dimensions: (Double, Double))

  def collide(target: GameObject)

  protected def x = position.x

  protected def y = position.y

  def goThroughScreenCorrection(border: (Double, Double)) {
    if (x < 0) position = Vec(x % border._1 + border._1, y)
    if (x > border._1) position = Vec(x % border._1, y)
    if (y < 0) position = Vec(x, y % border._2 + y)
    if (y > border._2) position = Vec(x, y % border._2)
  }

  def stayInCorrection(border: (Double, Double)): Unit = {
    if (x < 0) position = Vec(1, y)
    if (x > border._1) position = Vec(border._1 - 1, y)
    if (y < 0) position = Vec(x, 1)
    if (y > border._2) position = Vec(x, border._2 - 1)
  }

  def bounceCorrection = ???

  def insideBorder(border: (Double, Double)): Boolean =
    position.abs % Vec(border._1, border._2) == position

  override def toString = getClass.getSimpleName + " " + position
}
