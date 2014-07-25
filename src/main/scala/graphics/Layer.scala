package graphics

import objects.GameObject

class Layer {
  val entities = new scala.collection.mutable.ArrayBuffer[GameObject]

  def add(obj: GameObject) = entities += obj

  def remove(obj: GameObject) = entities -= obj

  def render() = for (entity <- entities) entity.draw()

  def update(delta: Int, dimensions: (Double, Double)) = for (entity <- entities) entity.update(delta, dimensions)


}
