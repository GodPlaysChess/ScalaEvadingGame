package mechanics

import scala.util.Random

/**
 * Immutable geometrical vector
 **/

final class Vec(val x: Double, val y: Double) {

  def +(other: Vec) = new Vec(x + other.x, y + other.y)

  def -(other: Vec) = new Vec(x - other.x, y - other.y)

  def *(n: Double) = new Vec(n * x, n * y)

  def /(n: Double) = new Vec(x / n, y / n)

  def %(n: Int) = Vec(x % n, y % n)

  def %(other: Vec) = Vec(x % other.x, y % other.y)

  def length = math.hypot(x, y)

  def normal = new Vec(x / length, y / length)

  def distance(other: Vec) = math.hypot(x - other.x, y - other.y)

  def >(other: Vec) = x > other.x && y > other.y

  def <(other: Vec) = x < other.x && y < other.y

  def ==(other: Vec) = x == other.x && y == other.y

  def abs = Vec(math.abs(x), math.abs(y))

  def this(pos: (Double, Double)) = this(pos._1, pos._2)

  override def toString = "[" + x + " , " + y + "]"

}

object Vec {
  def apply(x: Double, y: Double) = new Vec(x, y)
}

object RandomVec {
  def apply(borderLength: Number, borderHeight: Number) = new Vec(
    Random.nextInt(borderLength.intValue()),
    Random.nextInt(borderHeight.intValue())
  )
}
