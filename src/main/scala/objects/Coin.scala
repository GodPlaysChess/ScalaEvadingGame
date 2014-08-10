package objects

import graphics.Shapes
import mechanics.Vec
import org.lwjgl.opengl.GL11._

class Coin(pos: Vec) extends GameObject(pos) {


  override def size: Double = 10

  override def update(delta: Double, dimensions: (Double, Double)): Unit = ???

  override def draw(): Unit = {
    glColor3f(0.1f, 0.1f, 0.1f)
    Shapes.drawCircle(x, x, 10)
  }

  override def collide(target: GameObject): Unit = {
    //nothing happens here
  }
}
