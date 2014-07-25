package mechanics

import objects.GameObject

object CollisionDetector {
  def checkCollision(obj1: GameObject, obj2: GameObject) = obj1.position.distance(obj2.position) < (obj1.size + obj2.size)
}
