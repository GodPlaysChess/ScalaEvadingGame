package graphics

import mechanics.ObjectsFactory
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
  val enemiesWatcher = new ObjectsFactory(enemies, (length, height))

  def update(delta: Double) = {
    for (layer <- layers) layer.update(delta, (length, height))
    enemiesWatcher.updateLayer
  }

  def drawAll() = {
    for {
      layer <- layers
      entity <- layer.entities
    } yield entity.draw()
  }
}
