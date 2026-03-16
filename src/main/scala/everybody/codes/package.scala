package everybody.codes

import scala.annotation.targetName

final case class Coord(x: Long, y: Long):
  @targetName("plus") def +(other: Coord): Coord =
    Coord(x + other.x, y + other.y)

object Coord:
  def apply[I: Integral](x: I, y: I): Coord =
    import Integral.Implicits.*

    Coord(x.toLong, y.toLong)

sealed trait HV

enum Direction(val coord: Coord):
  case Up        extends Direction(Coord(0, 1)) with HV
  case UpRight   extends Direction(Coord(1, 1))
  case Right     extends Direction(Coord(1, 0)) with HV
  case DownRight extends Direction(Coord(1, -1))
  case Down      extends Direction(Coord(0, -1)) with HV
  case DownLeft  extends Direction(Coord(-1, -1))
  case Left      extends Direction(Coord(-1, 0)) with HV
  case UpLeft    extends Direction(Coord(-1, 1))

object Direction:
  def hvOnly: List[Direction & HV] = List(Up, Right, Down, Left)
