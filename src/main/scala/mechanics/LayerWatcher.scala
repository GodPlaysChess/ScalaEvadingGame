package mechanics

import graphics.Layer
import objects.Square
import utilities.Logging

import scala.util.Random

/**
 * another (probably better) way is to perform these operations within the
 * layer class. And the way to do this, one needs to subclass the layers.
 *
 * Or, depending of how it will go on, probably make this object singleton, and
 * it will watch All layers. Basically would be mechanic part of Screen, where
 * screen (and layers) are in charge for just rendering, and invoking updates.
 *
 *
 **/
class LayerWatcher(layer: Layer, border: (Double, Double)) extends Logging {
  val maxSquares = 5
  val maxSpeed = 2

  def completeLayer() = {
    if (layer.entities.size < maxSquares) {
      1 to (maxSquares - layer.entities.size) foreach {
        _ => layer.add(new Square(Vec(0, Random.nextDouble() * border._2), Random.nextDouble() * maxSpeed))
      }
      logger.info("Creating a new enemy")
    }
  }

}
