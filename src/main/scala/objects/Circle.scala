package objects

import general.InputTracker
import mechanics.Vec
import org.lwjgl.opengl.GL11._

class Circle(pos: Vec) extends GameObject(pos){
  def this(x1: Double, y1: Double) = this(new Vec(x1, y1))

  val radius = 50
  val MAX_SPEED = 5.0
  val TIME_TO_MAX_ACCELERATION: Int = 5000

  def calculateSpeed(time: Long) =
    if (math.abs(time) > TIME_TO_MAX_ACCELERATION) MAX_SPEED else MAX_SPEED * time / 3000


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
    // rotate quad
    // rotation += 0.15f * delta
    position -= new Vec(
      moveHorizontally(InputTracker.leftHold, InputTracker.rightHold),
      moveVertically(InputTracker.downHold, InputTracker.upHold)
    )
    correctAccordingScreenBorder(border)

    /*if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) x -= speed * delta
    if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) x += speed * delta

    if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) y -= speed * delta
    if (Keyboard.isKeyDown(Keyboard.KEY_UP)) y += speed * delta
*/

  }



}
/*  def moveLeft(time: Long) = x -= calculateSpeed(time)
  def moveRight(time: Long) = x += calculateSpeed(time)
  def moveDown(time: Long) = y -= calculateSpeed(time)
  def moveUp(time: Long) = y += calculateSpeed(time)*/
