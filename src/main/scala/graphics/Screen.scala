package graphics

class Screen {

  val length: Int = 800
  val width: Int = 600

  val backGround = new Layer
  val bullets = new Layer
  val enemies = new Layer
  val bonus = new Layer
  val fx = new Layer
  val frontground = new Layer
  val text = new Layer

  val layers = List(backGround, bullets, enemies, bonus, fx, frontground, text)

  def update(delta: Double) = {
    for (layer <- layers) layer.update(delta, (length, width))
  }

  def drawAll() = {
    for {
      layer <- layers
      entity <- layer.entities
    } yield entity.draw()
  }
}
