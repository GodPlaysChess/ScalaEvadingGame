package objects

import graphics.Shapes
import mechanics.Vec
import org.lwjgl.opengl.GL11._

import scala.util.Random

class Square(pos: Vec, speed: Double) extends GameObject(pos) {

  def this(x1: Double, y1: Double) = this(new Vec(x1, y1), 0.1)

  def this() = this(Vec(Random.nextInt(1000), Random.nextInt(1000)), math.random * 2)

  def this(speed: Double) = this(new Vec(Random.nextInt(1000), Random.nextInt(1000)), speed)

  override def draw() = {
    glColor3f(0.1f, 1f, 0.1f)
    Shapes.drawSquare(x, y, size)
  }

  override def update(delta: Double, border: (Double, Double)) = {
    position += Vec(speed * delta, 0)
    if (!insideBorder(border)) forRemove = true
  }

  override def size: Double = 10

  override def collide(target: GameObject): Unit = {
    //not implemented yet
  }

}
