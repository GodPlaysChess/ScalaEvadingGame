package objects

import general.InputTracker
import mechanics.Vec
import org.lwjgl.opengl.GL11._

class Circle(pos: Vec) extends GameObject(pos) {
  def this(x1: Double, y1: Double) = this(new Vec(x1, y1))

  val radius = 20
  val MAX_SPEED = 20.0
  val TIME_TO_MAX_ACCELERATION: Int = 1000

  def calculateSpeed(time: Long) =
    if (math.abs(time) > TIME_TO_MAX_ACCELERATION) MAX_SPEED else MAX_SPEED * time / TIME_TO_MAX_ACCELERATION

  def moveHorizontally(timeLeft: Long, timeRight: Long) = calculateSpeed(timeLeft - timeRight)

  def moveVertically(timeDown: Long, timeUp: Long) = calculateSpeed(timeDown - timeUp)

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

  def updatePosition(delta: Int, border: Pair[Double, Double]) {
    position -= new Vec(
      moveHorizontally(InputTracker.leftHold, InputTracker.rightHold),
      moveVertically(InputTracker.downHold, InputTracker.upHold)
    )
    correctAccordingScreenBorder(border)
  }

}
