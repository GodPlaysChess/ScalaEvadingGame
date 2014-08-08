package objects

import mechanics.Vec

abstract class GameObject(var position: Vec) {

  def size: Double

  def draw(): Unit

  def update(delta: Double, dimensions: (Double, Double))

  def collide(target: GameObject)

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
