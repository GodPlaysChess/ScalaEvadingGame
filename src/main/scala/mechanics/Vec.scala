package mechanics

/**
 * Immutable geometrical vector
 **/

final class Vec(val x: Double, val y: Double) {

  def +(other: Vec) = new Vec(x + other.x, y + other.y)

  def -(other: Vec) = new Vec(x - other.x, y - other.y)

  def *(n: Double) = new Vec(n * x, n * y)

  def /(n: Double) = new Vec(x / n, y / n)

  def length = math.hypot(x, y)

  def normal = new Vec(x / length, y / length)

  def distance(other: Vec) = math.hypot(x - other.x, y - other.y)

  override def toString = "[" + x + " , " + y + "]"

}

object Vec {
  def apply(x: Double, y: Double) = new Vec(x, y)
}
