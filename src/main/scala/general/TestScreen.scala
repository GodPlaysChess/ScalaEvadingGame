package general

import org.lwjgl.LWJGLException
import org.lwjgl.opengl.{GL11, DisplayMode, Display}
import GL11._

class TestScreen(x: Int, y: Int) {

  // Whether to enable VSync in hardware.
  val VSYNC = true

  // Width and height of our window
  val WIDTH = 800
  val HEIGHT = 600

  // Whether to use fullscreen mode
  val FULLSCREEN = false

  // Whether our game loop is running
  protected var running = false


  def initGL() = {
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    glOrtho(0, 800, 0, 600, 1, -1)
    glMatrixMode(GL_MODELVIEW)
  }

  def start() = {
    try {
      Display.setTitle("TestScreen")
      Display.setResizable(true)
      Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT))
      Display.setVSyncEnabled(true)
      Display.create()
    } catch {
      case e: LWJGLException => e.printStackTrace()
    }

    running = true
    while (running && !Display.isCloseRequested) {
      // If the game was resized, we need to update our projection
      if (Display.wasResized()) resize()

      // Render the game
      render()

      // Flip the buffers and sync to 60 FPS
      Display.update
      Display.sync(60)

    }
    dispose()
    Display.destroy()
  }

  def drawSquare() {
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)

    // set the color of the quad (R,G,B,A)
    glColor3f(0.5f, 0.5f, 1.0f)

    // draw quad
    glBegin(GL11.GL_QUADS)
    glVertex2f(100, 100)
    glVertex2f(100 + 200, 100)
    glVertex2f(100 + 200, 100 + 200)
    glVertex2f(100, 100 + 200)
    glEnd
    Display.update
  }

  def exit() = running = false

  protected def create() = {
    // 2D games generally won't require depth testing
    glDisable(GL_DEPTH_TEST)

    // Enable blending
    glEnable(GL_BLEND)
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA)

    // Set clear to transparent black
    glClearColor(0f, 0f, 0f, 0f)

    // ... initialize resources here ...
  }

  // Called to render our game
  def render() = {
    // Clear the screen
    glClear(GL_COLOR_BUFFER_BIT)

    // ... render our game here ...
  }

  // Called to resize our game
  protected def resize() {
    glViewport(0, 0, Display.getWidth, Display.getHeight)
    // ... update our projection matrices here ...
  }

  // Called to destroy our game upon exiting
  protected def dispose() {
    // ... dispose of any textures, etc ...
  }


}
