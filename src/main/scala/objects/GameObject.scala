package objects

import mechanics.Vec

abstract class GameObject(var position: Vec) {
  def update(delta: Int, dimensions: (Double, Double))

  def this(x1: Double, y1: Double) = this(new Vec(x1, y1))

  if (position.x < 0) position = new Vec(0, y)
  if (position.y < 0) position = new Vec(x, 0)

  protected def x = position.x

  protected def y = position.y

  def size: Double

  def draw()

  def correctAccordingScreenBorder(border: (Double, Double)) {
    if (x < 0) position += new Vec(border._1 + x, 0)
    if (x > border._1) position -= new Vec(border._1, 0)
    if (y < 0) position += new Vec(0, border._2)
    if (y > border._2) position -= new Vec(0, border._2)
  }

}
