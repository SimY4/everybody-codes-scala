package everybody.codes

final case class Timed[R](result: R, time: Long):
  override def toString: String = s"$result, time: ${time / 1000000}ms"

@main def run(): Unit =
  y2025.run()

def timed[R](block: => R): Timed[R] =
  val t0     = System.nanoTime()
  val result = block
  val t1     = System.nanoTime()
  Timed(result, t1 - t0)
