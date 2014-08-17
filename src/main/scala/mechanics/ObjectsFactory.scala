package mechanics

import graphics.Layer
import objects.Square
import utilities.Logging

import scala.util.Random

class ObjectsFactory(layer: Layer, border: (Double, Double)) extends Logging {
  val maxSquares = 5
  val maxSpeed = 2

  def updateLayer() = {
    if (layer.entities.size < maxSquares) {
      1 to (maxSquares - layer.entities.size) foreach {
        _ => layer.add(new Square(Vec(0, Random.nextDouble()*border._2), Random.nextDouble() * maxSpeed))
      }
      logger.info("Creating a new enemy")
    }
  }

}
