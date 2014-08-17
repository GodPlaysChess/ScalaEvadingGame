package graphics

import objects.GameObject
import utilities.Logging

class Layer extends Logging{
  val entities = new scala.collection.mutable.ArrayBuffer[GameObject]

  def add(obj: GameObject) = entities += obj

  def remove(obj: GameObject) = entities -= obj

  def render() = for (entity <- entities) entity.draw()

  def update(delta: Double, dimensions: (Double, Double)) = {
    for (entity <- entities) {
      entity.update(delta, dimensions)
    }
//    logger.info("removing " + entities.filter(obj => obj.forRemove).mkString(" ", ",", ""))
    entities --= entities.filter(obj => obj.forRemove)

  }

  override def toString = entities.toString()

}
