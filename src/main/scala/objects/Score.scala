package objects

import graphics.GFont
import mechanics.Vec
import org.newdawn.slick.Color


class Score(pos: Vec) extends GameObject(pos) {
  val font = new GFont("Times New Roman", 30)

  override def size: Double = 30

  override def update(delta: Double, dimensions: (Double, Double)): Unit = correctAccordingScreenBorder(dimensions)

  override def draw(): Unit = {
//    glColor3f(0.9f, 0.9f, 1f)
//    glPushMatrix()

    Color.white.bind()
    font.drawString(pos.x, pos.y, "Score: ", Color.yellow)
//    glEnd()
//    glPopMatrix()
  }

  override def collide(target: GameObject): Unit = return
}
