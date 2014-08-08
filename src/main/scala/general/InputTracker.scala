package general

import org.lwjgl.input.Keyboard

object InputTracker {
//  private var leftKeyHoldAbsolute = 0l
//  private var rightKeyHoldAbsolute = 0l
//  private var downKeyHoldAbsolute = 0l
//  private var upKeyHoldAbsolute = 0l

  var leftPressed = false
  var rightPressed = false
  var downPressed = false
  var upPressed = false

//  def leftHold: Long =
//    if (leftKeyHoldAbsolute > 0) (System.nanoTime() - leftKeyHoldAbsolute) / 1000000
//    else 0
//
//  def rightHold: Long =
//    if (rightKeyHoldAbsolute > 0) (System.nanoTime() - rightKeyHoldAbsolute) / 1000000
//    else 0
//
//  def downHold: Long =
//    if (downKeyHoldAbsolute > 0) (System.nanoTime() - downKeyHoldAbsolute) / 1000000
//    else 0
//
//  def upHold: Long =
//    if (upKeyHoldAbsolute > 0) (System.nanoTime() - upKeyHoldAbsolute) / 1000000
//    else 0

  def simpleTrack() = {
    if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) leftPressed = true else leftPressed = false
    if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) rightPressed = true else rightPressed = false
    if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) downPressed = true else downPressed = false
    if (Keyboard.isKeyDown(Keyboard.KEY_UP)) upPressed = true else upPressed = false
  }

//  def track() = {
//    if (Keyboard.isKeyDown(Keyboard.KEY_LEFT) && leftKeyHoldAbsolute == 0) leftKeyHoldAbsolute = System.nanoTime()
//    if (!Keyboard.isKeyDown(Keyboard.KEY_LEFT)) leftKeyHoldAbsolute = 0
//
//    if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT) && rightKeyHoldAbsolute == 0) rightKeyHoldAbsolute = System.nanoTime()
//    if (!Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) rightKeyHoldAbsolute = 0
//
//    if (Keyboard.isKeyDown(Keyboard.KEY_UP) && upKeyHoldAbsolute == 0) upKeyHoldAbsolute = System.nanoTime()
//    if (!Keyboard.isKeyDown(Keyboard.KEY_UP)) upKeyHoldAbsolute = 0
//
//
//    if (Keyboard.isKeyDown(Keyboard.KEY_DOWN) && downKeyHoldAbsolute == 0) downKeyHoldAbsolute = System.nanoTime()
//    if (!Keyboard.isKeyDown(Keyboard.KEY_DOWN)) downKeyHoldAbsolute = 0
//  }

}
