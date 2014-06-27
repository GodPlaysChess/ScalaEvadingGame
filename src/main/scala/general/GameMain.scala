package general

import org.lwjgl.opengl.{GL11, DisplayMode, Display}
import objects.{GameObject, Square, Circle}
import org.lwjgl.input.Keyboard
import org.lwjgl.{Sys, LWJGLException}

object GameMain {

  def main(args: Array[String]) {
    GameMain.start()
  }
  val screenSizeX: Int = 800
  val screenSizeY: Int = 600
  var lastFrame = -1l
  var fps = 0
  var lastFPS = -1l
  val FPS_CAP = 100
  val circle = new Circle(50, 50)
  val square = new Square(100, 100)
  val allObjects: List[GameObject] = List(circle, square)

  def start() {
    createDisplay()
    initializeGL()
    initializeFpsTimer()
    runLoop()
    Display.destroy()
  }

  private def runLoop() = {
    while (!Display.isCloseRequested) {
      readInput()
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
    Display.sync(FPS_CAP)
  }

  private def drawObjects() = {
    GL11.glColor3f(0.5f, 0.5f, 1.0f)
    for (obj <- allObjects) obj.draw()
  }


  private def createDisplay() {
    try {
      Display.setDisplayMode(new DisplayMode(screenSizeX, screenSizeY))
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

  private def updateObjects() = {
    for (obj <- allObjects) obj.updatePosition(getDelta, (screenSizeX, screenSizeY))
//    println("delta= " + getDelta)
  }

  def readInput() = InputTracker.track()
}
