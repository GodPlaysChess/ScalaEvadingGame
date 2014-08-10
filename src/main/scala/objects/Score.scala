package objects

import general.Timer
import graphics.GFont
import mechanics.Vec
import org.lwjgl.opengl.GL11._
import org.newdawn.slick.Color

   //http://www.java-gaming.org/index.php?topic=26944.0
class Score(pos: Vec) extends GameObject(pos) {
  val font = new GFont("Times New Roman", 30)
//  val unicodeFont = new UnicodeFont(font)

  override def size: Double = 30

  override def update(delta: Double, dimensions: (Double, Double)): Unit = goThroughScreenCorrection(dimensions)

  override def draw(): Unit = {
    glEnable(GL_BLEND)
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA)
    font.drawString(pos.x, pos.y, "Score: " + Timer.timeS, Color.yellow)
    glDisable(GL_BLEND)
  }

  override def collide(target: GameObject): Unit = return
}
