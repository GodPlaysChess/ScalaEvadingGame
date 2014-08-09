package graphics

import java.awt.Font

import org.newdawn.slick.{TrueTypeFont, Color}

/**
 *   Wrapper around default java font, using slick2D
 *
 */
class GFont(val name: String, val size: Int) {
  private val awtFont = new Font(name, Font.PLAIN, size)
  private val font = new TrueTypeFont(awtFont, true)

  def drawString(x: Double, y: Double, text: String, color: Color) =
    font.drawString(x.asInstanceOf[Float], y.asInstanceOf[Float], text, color)

}
