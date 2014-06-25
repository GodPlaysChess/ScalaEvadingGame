package objects

import org.lwjgl.input.Keyboard
import org.lwjgl.opengl.GL11._

class Circle(var x: Double, var y: Double) {
  def moveDown() = y -= 1

  def moveUp() = y += 1

  val radius = 50

  def moveLeft() = x -= 1

  def moveRight() = x += 1


  def draw() = {
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

  def update(delta: Int) {
    // rotate quad
    //rotation += 0.15f * delta

    if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) x -= 0.35f * delta
    if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) x += 0.35f * delta

    if (Keyboard.isKeyDown(Keyboard.KEY_UP)) y -= 0.35f * delta
    if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) y += 0.35f * delta

    if (x < 0) x = 0
    if (x > 800) x = 800
    if (y < 0) y = 0
    if (y > 600) y = 600
  }

  def drawQuad() = {
    // draw quad
    glPushMatrix()
    //  glTranslated(x, y, 0)
    //glRotatef(rotation, 0f, 0f, 1f)
    //  glTranslated(-x, -y, 0)

    glBegin(GL_QUADS)
    glVertex2d(x - 50, y - 50)
    glVertex2d(x + 50, y - 50)
    glVertex2d(x + 50, y + 50)
    glVertex2d(x - 50, y + 50)
    glEnd()
    glPopMatrix()
  }


}
