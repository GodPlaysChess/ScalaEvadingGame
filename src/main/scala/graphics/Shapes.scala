package graphics

import org.lwjgl.opengl.GL11._

object Shapes {

  def drawCircle(x: Double, y: Double, radius: Int) = {
    glColor3f(0.5f, 0.5f, 0.9f)
    glPushMatrix()
    glTranslated(x, y, 0)
    glScalef(radius, radius, 1)

    glBegin(GL_TRIANGLE_FAN)
    glVertex2d(0, 0)

    for (i <- 0 to 50) {
      val angle = Math.PI * 2 * i / 50
      glVertex2d(Math.cos(angle), Math.sin(angle))
    }
    glEnd()

    glPopMatrix()
  }
}
