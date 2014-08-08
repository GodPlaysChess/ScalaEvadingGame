package objects

import general.InputTracker
import mechanics.Vec
import org.lwjgl.opengl.GL11._

class Circle(pos: Vec) extends GameObject(pos) {
  def this(x1: Double, y1: Double) = this(new Vec(x1, y1))

  private val radius = 20
  private var speed = 0.5

  override def draw() = {

    glColor3f(0.5f, 0.5f, 0.9f)
    glPushMatrix()
    glTranslated(x, y, 0)
    glScalef(radius, radius, 1)

    glBegin(GL_TRIANGLE_FAN)
    glVertex2d(0, 0)

    for (i <- 0 to 50) { // i - number of circle edges
      val angle = Math.PI * 2 * i / 50
      glVertex2d(Math.cos(angle), Math.sin(angle))
    }
    glEnd()

    glPopMatrix()
  }

  override def update(delta: Double, border: (Double, Double)) {
    var horizontalShift, verticalShift = 0.0
    if (InputTracker.leftPressed) horizontalShift += speed
    if (InputTracker.rightPressed) horizontalShift -= speed
    if (InputTracker.downPressed) verticalShift += speed
    if (InputTracker.upPressed) verticalShift -= speed
    position -= Vec(horizontalShift * delta, verticalShift * delta)
    correctAccordingScreenBorder(border)
  }

  override def size: Double = radius

  override def collide(target: GameObject): Unit = target match {
    case _: Square => crash()
    case _: Circle => "will implement later"
    case _ => "thrown an exception"
  }

  def crash() = {
    speed = 0
    println("collide")
  }


}
