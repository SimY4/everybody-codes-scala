package everybody.codes.y2025

object Quest2:
  final private case class Complex(x: Long, y: Long):
    def +(other: Complex): Complex = Complex(x + other.x, y + other.y)
    def *(other: Complex): Complex = Complex(x * other.x - y * other.y, x * other.y + y * other.x)
    def /(other: Complex): Complex = Complex(x / other.x, y / other.y)
    override def toString: String  = s"[$x,$y]"

  def solve(input: String): String =
    val s"A=[$x,$y]" = input
    val A            = Complex(x.toLong, y.toLong)

    Iterator
      .iterate(Complex(0, 0)) { v =>
        v * v / Complex(10, 10) + A
      }
      .drop(3)
      .next
      .toString

  def solve2(input: String, by: Int = 10): Int =
    val s"A=[$x,$y]" = input
    val A            = Complex(x.toLong, y.toLong)

    (for
      y <- A.y to A.y + 1000 by by
      x <- A.x to A.x + 1000 by by
      check = Iterator
        .iterate(Complex(0, 0)) { v =>
          v * v / Complex(100000, 100000) + Complex(x, y)
        }
        .drop(100)
        .next
      if check.x.abs < 1000000 && check.y.abs < 1000000
    yield check).size

  def solve3(input: String): Int = solve2(input, by = 1)

  val input = "A=[160,58]"

  val input2 = "A=[-4571,-68892]"

  val input3 = "A=[-4571,-68892]"
