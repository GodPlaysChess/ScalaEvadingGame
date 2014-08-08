package objects

import mechanics.Vec

abstract class GameObject(var position: Vec) {

  //  if (position.x < 0) position = new Vec(0, y)
  //  if (position.y < 0) position = new Vec(x, 0)
  def size: Double

  def draw(): Unit

  def update(delta: Double, dimensions: (Double, Double))

  def collide(target: GameObject)

//  def this(x1: Double, y1: Double) = this(new Vec(x1, y1))

  protected def x = position.x

  protected def y = position.y

  def correctAccordingScreenBorder(border: (Double, Double)) {
    if (x < 0) position = Vec(x % border._1 + border._1, y)
    if (x > border._1) position = Vec(x % border._1, y)
    if (y < 0) position = Vec(x, y % border._2 + y)
    if (y > border._2) position = Vec(x, y % border._2)
  }

  override def toString = getClass.getSimpleName + " " + position
}
