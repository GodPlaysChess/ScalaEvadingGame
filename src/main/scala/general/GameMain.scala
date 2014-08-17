package general

import mechanics.{CollisionDetector, Vec}
import objects.{Square, Circle, Score}
import org.lwjgl.opengl.{Display, DisplayMode, GL11}
import org.lwjgl.{LWJGLException, Sys}

// http://fabiensanglard.net/Prototyp/ check this out
object GameMain {

  def main(args: Array[String]) {
    GameMain.start()
  }

  private var lastFrame = -1l
  private var fps = 0
  private var lastFPS = -1l
  private val screen = new graphics.Screen
  private val FPS_CAP = 100

  private val collisionDetector = new CollisionDetector

  def start() {
    createDisplay()
    initializeGL()
    initializeFpsTimer()
    initializeInitialDisposition()
    runLoop()
    Display.destroy()
  }

  def initializeInitialDisposition() = {
    val circle = new Circle(screen.length/2, screen.height/2)
    val square = new Square(100, 100)
    screen.foreground.add(circle)
    screen.enemies.add(square)
    screen.enemies.add(new Square())
    screen.enemies.add(new Square(1))
    screen.enemies.add(new Square(0.3))

    screen.text.add(new Score(Vec(screen.length - 120, 0)))

    println(screen.enemies)
  }

  private def runLoop() = {
    while (!Display.isCloseRequested) {
      readInput()
      updateObjects()
      checkCollisions()
      updateScreen()
    }
  }

  def readInput() = InputTracker.simpleTrack()

  private def updateObjects() = {
    screen.update(getDelta)
  }

  private def checkCollisions() = collisionDetector.check(screen.enemies, screen.bullets, screen.foreground)

  // Calculate how many milliseconds have passed since last frame
  private def getDelta: Double = {
    val time = getTime
    val delta = time - lastFrame
    lastFrame = time
    delta
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
      Display.setDisplayMode(new DisplayMode(screen.length, screen.height))
      Display.create()
    } catch {
      case e: LWJGLException => e.printStackTrace()
    }
  }

  private def initializeGL() {
    GL11.glMatrixMode(GL11.GL_PROJECTION)
    GL11.glLoadIdentity()
    GL11.glOrtho(0, screen.length, screen.height, 0, 1, -1)
    GL11.glMatrixMode(GL11.GL_MODELVIEW)
  }

  private def initializeFpsTimer() = {
    getDelta // initialise lastFrame
    lastFPS = getTime // initialise fps timer
  }

}
