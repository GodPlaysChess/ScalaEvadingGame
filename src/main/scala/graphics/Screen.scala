package graphics

import objects.GameObject

class Screen {

  val length: Int = 800
  val width: Int = 600

  val background = new Layer
  val bullets = new Layer
  val enemies = new Layer
  val bonus = new Layer
  val fx = new Layer
  val foreground = new Layer
  val text = new Layer

  val layers = List(background, bullets, enemies, bonus, fx, foreground, text)

  def update(delta: Double) = {
    for (layer <- layers) layer.update(delta, (length, width))
  }

  private def outOfScreen(obj: GameObject): Boolean =
    obj.position.x > length || obj.position.x < 0 || obj.position.y > width || obj.position.y < 0

  def removeWhenOutOfScreen(obj: GameObject, layer: Layer) = if (outOfScreen(obj)) layer.remove(obj)

  def drawAll() = {
    for {
      layer <- layers
      entity <- layer.entities
    } yield entity.draw()
  }
}
