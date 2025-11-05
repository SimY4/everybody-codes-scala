package everybody.codes.y2025

object Quest1:
  def solve(input: String): String =
    val names :: instructions :: Nil = input.linesIterator.filter(_.nonEmpty).map(_.split(",")).toList

    def navigate(pos: Int, ins: String): Int = ins match
      case s"L$n" => 0 max (pos - n.toInt)
      case s"R$n" => (pos + n.toInt) min (names.length - 1)

    names(instructions.foldLeft(0)(navigate))

  def solve2(input: String): String =
    val names :: instructions :: Nil = input.linesIterator.filter(_.nonEmpty).map(_.split(",")).toList

    def navigate(pos: Int, ins: String): Int = ins match
      case s"L$n" => (names.length + pos - n.toInt) % names.length
      case s"R$n" => (pos + n.toInt)                % names.length

    names(instructions.foldLeft(0)(navigate))

  val input = """Felngaz,Elvarvoran,Xarxal,Calvynar,Silther,Calvalir,Iskariral,Ulagrath,Xendfal,Zyrthyn
                |
                |L1,R3,L7,R3,L1,R7,L1,R6,L4,R3,L2""".stripMargin

  val input2 =
    """Lazcarth,Jalyth,Harparth,Felnfroth,Raelnixis,Tyroth,Ulmarlon,Sorroth,Ralvor,Ozandrith,Sarxith,Ascalorath,Raelverax,Kharhal,Aelithorath,Ulknix,Xaradar,Arkadir,Lithvynar,Xilzris
      |
      |L16,R6,L15,R14,L11,R14,L12,R8,L14,R17,L5,R18,L5,R10,L5,R17,L5,R18,L5,R16,L11,R17,L17,R18,L19,R19,L7,R16,L16""".stripMargin
