package mechanics

/**
 * Immutable
 **/

final class Vec(val x: Double, val y: Double) {

  def +(other: Vec) = new Vec(x + other.x, y + other.y)

  def -(other: Vec) = new Vec(x - other.x, y - other.y)

  def *(n: Double) = new Vec(n * x, n * y)

  def /(n: Double) = new Vec(x / n, y / n)

  def length = math.hypot(x, y)

  def normal = new Vec(x / length, y / length)

  override def toString = "( " + x + " , " + y + " )"

}
