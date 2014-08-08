package mechanics

import graphics.Layer
import objects.GameObject

import scala.collection.mutable.ArrayBuffer

class CollisionDetector {

  def check(layers: Layer*) = {
    layers.foldLeft(new ArrayBuffer[GameObject])((acc, layer) => acc ++ layer.entities).
      combinations(2).foreach(x => checkCollision(x(0), x(1)))
  }

  private def checkCollision(obj1: GameObject, obj2: GameObject) =
    if (obj1.position.distance(obj2.position) < (obj1.size + obj2.size)) {
      obj1.collide(obj2)
      obj2.collide(obj1)
    }
}
