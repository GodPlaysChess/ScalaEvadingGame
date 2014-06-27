package objects

import mechanics.Vec

abstract class GameObject(var position: Vec) {
  def this(x1: Double, y1: Double) = this(new Vec(x1, y1))

  def x = position.x
  def y = position.y

  def draw()

  def updatePosition(delta: Int)

}
