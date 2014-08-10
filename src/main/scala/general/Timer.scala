package general

import org.lwjgl.Sys

object Timer {
  private val initialTime = Sys.getTime

  def timeMs = Sys.getTime - initialTime
  
  def timeS = (Sys.getTime - initialTime)/1000

}
