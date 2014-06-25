package general

import objects.Circle
import org.lwjgl.input.Keyboard
import org.lwjgl.{Sys, LWJGLException}
import org.lwjgl.opengl.{GL11, DisplayMode, Display}

object TimerExample {

  def main(args: Array[String]) {
    TimerExample.start()
  }

  var lastFrame = -1l
  var fps = 0
  var lastFPS = -1l
  val circle = new Circle(50, 50)

  def start() {
    createDisplay()
    initializeGL()
    initializeFpsTimer()
    runLoop()
    Display.destroy()
  }

  private def runLoop() = {
    while (!Display.isCloseRequested) {
      updateObjects()
      updateScreen()
    }
  }

  // Calculate how many milliseconds have passed since last frame
  private def getDelta: Int = {
    val time = getTime
    val delta = time - lastFrame
    lastFrame = time
    delta.asInstanceOf[Int]
  }

  private def getTime: Long = Sys.getTime * 1000 / Sys.getTimerResolution

  private def updateTitleToFps() {
    if (getTime - lastFPS > 1000) {
      Display.setTitle("FPS: " + fps)
      fps = 0
      lastFPS += 1000
    }
    fps += 1
  }

  private def updateScreen() {
    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT)
    drawObjects()
    updateTitleToFps()
    Display.update()
    Display.sync(60) // cap fps to 60
  }

  private def drawObjects() = {
    GL11.glColor3f(0.5f, 0.5f, 1.0f)
    circle.draw()
  }

  private def createDisplay() {
    try {
      Display.setDisplayMode(new DisplayMode(800, 600))
      Display.create()
    } catch {
      case e: LWJGLException => e.printStackTrace()
    }
  }

  private def initializeGL() {
    GL11.glMatrixMode(GL11.GL_PROJECTION)
    GL11.glLoadIdentity()
    GL11.glOrtho(0, 800, 0, 600, 1, -1)
    GL11.glMatrixMode(GL11.GL_MODELVIEW)
  }

  private def initializeFpsTimer() = {
    getDelta // initialise lastFrame
    lastFPS = getTime // initialise fps timer
  }

  private def updateMovement() = {
    if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) circle.moveLeft()
    if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) circle.moveRight()
    if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) circle.moveDown()
    if (Keyboard.isKeyDown(Keyboard.KEY_UP)) circle.moveUp()
  }

  private def updateObjects() = {
    updateMovement()
  }


}
