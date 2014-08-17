package graphics

import utilities.Logging


class Screen extends Logging {

  val length: Int = 800
  val height: Int = 600

  val background = new Layer
  val bullets = new Layer
  val enemies = new Layer
  val bonus = new Layer
  val fx = new Layer
  val foreground = new Layer
  val text = new Layer

  val layers = List(background, bullets, enemies, bonus, fx, foreground, text)

  def update(delta: Double) = {
    for (layer <- layers) layer.update(delta, (length, height))

    // creation enemies logic. Dedicate this to factory
//    if (enemies.entities.size < 2) {
//      1 to (2 - enemies.entities.size) foreach { _ => enemies.add(new Square(11, Random.nextInt(height)))}
//      logger.info("Creating a new enemy")
//    }
  }

  def drawAll() = {
    for {
      layer <- layers
      entity <- layer.entities
    } yield entity.draw()
  }
}
