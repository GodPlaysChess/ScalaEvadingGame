package objects

import mechanics.Vec
import org.lwjgl.opengl.GL11._

class Square(pos: Vec) extends GameObject(pos) {


  val speed = 1

  def this(x1: Double, y1: Double) = this(new Vec(x1, y1))

  override def draw() = {
    glColor3f(0.1f, 1f, 0.1f)
    glPushMatrix()
    glBegin(GL_QUADS)
    glVertex2d(x - size, y - size)
    glVertex2d(x + size, y - size)
    glVertex2d(x + size, y + size)
    glVertex2d(x - size, y + size)
    glEnd()
    glPopMatrix()

  }

  override def update(delta: Int, border: (Double, Double)) = {
    position += new Vec(speed * delta, 0)
    correctAccordingScreenBorder(border)
    //println(position)
  }

  override def size: Double = 10
}
