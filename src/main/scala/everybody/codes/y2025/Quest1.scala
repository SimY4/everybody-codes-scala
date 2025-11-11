package everybody.codes.y2025

object Quest1:
  def solve(input: String): String =
    val names :: instructions :: Nil = input.split(System.lineSeparator() * 2).map(_.split(",")).toList

    def navigate(pos: Int, ins: String): Int = ins match
      case s"L$n" => 0 max (pos - n.toInt)
      case s"R$n" => (pos + n.toInt) min (names.length - 1)

    names(instructions.foldLeft(0)(navigate))

  def solve2(input: String): String =
    val names :: instructions :: Nil = input.split(System.lineSeparator() * 2).map(_.split(",")).toList

    def navigate(pos: Int, ins: String): Int = ins match
      case s"L$n" => (names.length + pos - n.toInt) % names.length
      case s"R$n" => (pos + n.toInt)                % names.length

    names(instructions.foldLeft(0)(navigate))

  def solve3(input: String): String =
    val names :: instructions :: Nil = input.split(System.lineSeparator() * 2).map(_.split(",")).toList

    def navigate(pos: Int, ins: String): Int = ins match
      case s"L$n" => (names.length + pos - n.toInt) % names.length
      case s"R$n" => (pos + n.toInt)                % names.length

    instructions.foreach: ins =>
      val swapPos = ins match
        case s"L$n" => (names.length * 10 - n.toInt) % names.length
        case s"R$n" => n.toInt                       % names.length

      val name = names(0)
      names(0) = names(swapPos)
      names(swapPos) = name

    names(0)

  val input = """Felngaz,Elvarvoran,Xarxal,Calvynar,Silther,Calvalir,Iskariral,Ulagrath,Xendfal,Zyrthyn
                |
                |L1,R3,L7,R3,L1,R7,L1,R6,L4,R3,L2""".stripMargin

  val input2 =
    """Lazcarth,Jalyth,Harparth,Felnfroth,Raelnixis,Tyroth,Ulmarlon,Sorroth,Ralvor,Ozandrith,Sarxith,Ascalorath,Raelverax,Kharhal,Aelithorath,Ulknix,Xaradar,Arkadir,Lithvynar,Xilzris
      |
      |L16,R6,L15,R14,L11,R14,L12,R8,L14,R17,L5,R18,L5,R10,L5,R17,L5,R18,L5,R16,L11,R17,L17,R18,L19,R19,L7,R16,L16""".stripMargin

  val input3 =
    """Drazmirix,Sarnvor,Thazpyxis,Quarndax,Breldax,Karthfarin,Cyndxaril,Fenmal,Xilryn,Agnarnix,Rythanilor,Zalisis,Krynnlith,Ozansin,Urural,Orypyxis,Sorzryn,Thyrosther,Zyrixrax,Harnzryn,Dorwyris,Thalophis,Felmarzyth,Zorsor,Lorncion,Xaralulth,Wyrardith,Xaralural,Lirris,Galbryn
      |
      |L30,R19,L12,R28,L35,R34,L35,R28,L23,R42,L32,R7,L22,R46,L46,R37,L9,R16,L24,R5,L5,R25,L5,R11,L5,R40,L5,R37,L5,R16,L5,R43,L5,R39,L5,R31,L5,R17,L5,R29,L32,R10,L5,R16,L8,R40,L31,R5,L13,R49,L20,R30,L9,R16,L25,R26,L14,R17,L11""".stripMargin
