package objects

import general.InputTracker
import graphics.Shapes
import mechanics.Vec
import org.lwjgl.opengl.GL11._

class Circle(pos: Vec) extends GameObject(pos) {
  def this(x1: Double, y1: Double) = this(new Vec(x1, y1))

  private val radius = 20
  private var speed = 0.5

  override def draw() = {
    glColor3f(0.5f, 0.5f, 0.9f)
    Shapes.drawCircle(x, y, radius)
  }

  override def update(delta: Double, border: (Double, Double)) {
    var horizontalShift, verticalShift = 0.0
    if (InputTracker.isLeftPressed) horizontalShift += speed
    if (InputTracker.isRightPressed) horizontalShift -= speed
    if (InputTracker.isDownPressed) verticalShift -= speed
    if (InputTracker.isUpPressed) verticalShift += speed
    position -= Vec(horizontalShift * delta, verticalShift * delta)
    stayInCorrection(border)
  }

  override def size: Double = radius

  def addScore(): Unit = ???

  override def collide(target: GameObject): Unit = target match {
    case _: Square => crash()
    case _: Coin => addScore()
//    case _ => "thrown an exception"
  }

  def crash() = {
    speed = 1
    forRemove = true
  }
}
