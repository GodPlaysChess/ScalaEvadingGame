package objects

import mechanics.Vec
import org.lwjgl.opengl.GL11._

class Square(pos: Vec) extends GameObject(pos) {

  val size: Int = 10
  val speed = 10

  def this(x1: Double, y1: Double) = this(new Vec(x1, y1))

  override def draw() = {
    glPushMatrix()
    //  glTranslated(x, y, 0)
    //  glRotatef(rotation, 0f, 0f, 1f)
    //  glTranslated(-x, -y, 0)

    glBegin(GL_QUADS)

    glVertex2d(x - size, y - size)
    glVertex2d(x + size, y - size)
    glVertex2d(x + size, y + size)
    glVertex2d(x - size, y + size)
    glEnd()
    glPopMatrix()

  }

  override def updatePosition(delta: Int, border: Pair[Double, Double]) = {
    position += new Vec(speed, 0)
    correctAccordingScreenBorder(border)
    println(position)
  }


}
