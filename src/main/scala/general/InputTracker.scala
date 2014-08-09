package general

import org.lwjgl.input.Keyboard

object InputTracker {

  private var leftPressed = false
  private var rightPressed = false
  private var downPressed = false
  private var upPressed = false

  def simpleTrack() = {
    if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) leftPressed = true else leftPressed = false
    if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) rightPressed = true else rightPressed = false
    if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) downPressed = true else downPressed = false
    if (Keyboard.isKeyDown(Keyboard.KEY_UP)) upPressed = true else upPressed = false
  }

  def isLeftPressed = leftPressed
  def isRightPressed = rightPressed
  def isDownPressed = downPressed
  def isUpPressed = upPressed
}
