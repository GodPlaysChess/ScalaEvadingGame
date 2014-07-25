package general

import org.lwjgl.opengl.{GL11, DisplayMode, Display}
import objects.{GameObject, Square, Circle}
import org.lwjgl.input.Keyboard
import org.lwjgl.{Sys, LWJGLException}

// http://fabiensanglard.net/Prototyp/ check this out
object GameMain {

  def main(args: Array[String]) {
    GameMain.start()
  }
   
  var lastFrame = -1l
  var fps = 0
  var lastFPS = -1l
  val FPS_CAP = 100
  val circle = new Circle(50, 50)
  val square = new Square(100, 100)
  val screen = new graphics.Screen
  screen.enemies.add(circle)
  screen.frontground.add(square)
  

  def start() {
    createDisplay()
    initializeGL()
    initializeFpsTimer()
    runLoop()
    Display.destroy()
  }

  private def runLoop() = {
    while (!Display.isCloseRequested) {

      // tick()
      // updateEntities()
      // check collisions()
      // render()

      readInput()
      updateObjects()
      checkCollisions()
      updateScreen()
    }
  }

  def readInput() = InputTracker.simpleTrack()

  private def updateObjects() = {
    screen.update(getDelta) // keep one of these
  }

  def checkCollisions() = ???

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
    screen.drawAll()
  }


  private def createDisplay() {
    try {
      Display.setDisplayMode(new DisplayMode(screen.length, screen.width))
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

}
