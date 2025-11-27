package everybody.codes.y2025

object Quest7:
  def solve(input: String): Option[String] =
    val names :: rules :: Nil = input.split(System.lineSeparator() * 2).toList

    val rulesMap = rules.linesIterator
      .map:
        case s"$lhr > $rhs" => lhr(0) -> rhs.split(",").map(_(0)).toSet
      .toMap

    names
      .split(",")
      .find: name =>
        name.indices.foldLeft(true): (acc, i) =>
          if i < name.length - 1 then acc && rulesMap.get(name(i)).exists(set => set(name(i + 1)))
          else acc

  def solve2(input: String): Int =
    val names :: rules :: Nil = input.split(System.lineSeparator() * 2).toList

    val rulesMap = rules.linesIterator
      .map:
        case s"$lhr > $rhs" => lhr(0) -> rhs.split(",").map(_(0)).toSet
      .toMap

    names
      .split(",")
      .zipWithIndex
      .filter: (name, _) =>
        name.indices.foldLeft(true): (acc, i) =>
          if i < name.length - 1 then acc && rulesMap.get(name(i)).exists(set => set(name(i + 1)))
          else acc
      .map((_, i) => i + 1)
      .sum

  def solve3(input: String): Int =
    val prefixes :: rules :: Nil = input.split(System.lineSeparator() * 2).toList

    val rulesMap = rules.linesIterator
      .map:
        case s"$lhr > $rhs" => lhr(0) -> rhs.split(",").map(_(0)).toSet
      .toMap

    def tree(ch: Char, depth: Int, acc: List[Char] = Nil): Set[List[Char]] =
      val len = depth + acc.length
      if len > 11 then Set(acc)
      else
        val next = rulesMap.getOrElse(ch, Set.empty)

        val res =
          if next.isEmpty then if len < 6 then Set.empty else Set(ch :: acc)
          else next.flatMap(tree(_, depth, ch :: acc))

        if len < 7 then res else res + (ch :: acc)

    prefixes
      .split(",")
      .toSet
      .filter: prefix =>
        prefix.indices.foldLeft(true): (acc, i) =>
          if i < prefix.length - 1 then acc && rulesMap.get(prefix(i)).exists(set => set(prefix(i + 1)))
          else acc
      .flatMap: prefix =>
        tree(prefix.last, prefix.length).map(prefix.init + _.reverse.mkString)
      .size

  val input = """Ulzris,Oronther,Nyzris,Nyendris,Nyther,Ulther,Ulendris,Oronendris,Oronzris
                |
                |h > e
                |e > n,r
                |N > y
                |l > e,b
                |O > r
                |o > n
                |U > l
                |t > h
                |n > d,t,z,e
                |r > i,b
                |d > r
                |z > r
                |y > b
                |i > s""".stripMargin

  val input2 =
    """Tormyr,Oryquin,Kalloris,Palthiral,Ardenloris,Eldenxar,Palthxar,Eldenquin,Eldencarth,Palthloris,Torlith,Palthlith,Brylzyph,Orymyr,Irynlith,Irynmyr,Erasquin,Palthquin,Shaelquin,Oryzyph,Palthmarn,Erasxar,Eldenzyph,Ardenlith,Erasiral,Eldeniral,Brylquin,Eldenvalir,Bryllith,Palthcarth,Kalmyr,Shaelmarn,Brylxar,Ardenxar,Kaliral,Erasloris,Eldenmarn,Orycarth,Kalquin,Erasmyr,Erascarth,Ardenmyr,Palthvalir,Brylvalir,Torloris,Shaelvalir,Torquin,Eldenloris,Shaelloris,Irynloris,Iryniral,Shaellith,Orymarn,Kalmarn,Oryiral,Irynquin,Oryxar,Torcarth,Kallith,Oryvalir,Eraslith,Ardenzyph,Kalxar,Brylcarth,Shaelzyph,Torvalir,Eldenlith,Orylith,Torzyph,Shaelmyr,Kalzyph,Ardenquin,Ardencarth,Oryloris,Ardenmarn,Eldenmyr,Kalcarth,Irynvalir,Shaeliral,Palthzyph,Erasvalir,Irynxar,Ardeniral,Toriral,Kalvalir,Torxar,Tormarn,Shaelxar,Ardenvalir,Shaelcarth,Palthmyr,Irynzyph,Erasmarn,Brylloris,Irynmarn,Iryncarth,Brylmyr,Brylmarn,Bryliral,Eraszyph
      |
      |n > m,z,v,i,l,x,c,q
      |l > t,i,o,v,m,z,l,x,c,q
      |T > o
      |m > a,y
      |t > h
      |c > a
      |A > r
      |u > i
      |x > a
      |d > e
      |a > l,r,v,e,s
      |B > r
      |r > v,n,a,i,t,m,z,l,x,c,q
      |S > h
      |P > a
      |v > a
      |E > l,r
      |O > r
      |I > r
      |h > x,v,m,z,i,l,c,q
      |e > n,l
      |K > a
      |z > y
      |o > r,v
      |q > u
      |p > h
      |i > r,s,t,n
      |y > p,r,m,z,v,i,l,x,c,q,n
      |s > m,z,v,i,l,x,c,q""".stripMargin

  val input3 =
    """Ny,Nyl,Nyth,Nyss,Nyrix,Axal,Kryth,Aer,Wyr,Ael,Tir,Vyr,Draz,Gal,Draith,Feln,Dar,Selk,Mor,Ylar
      |
      |v > o
      |Y > l
      |x > e,r,q,d,n,o,g,z,v
      |e > l,n,t,v
      |D > r,a
      |F > e
      |r > o,y,i,a,e,v,r,q,d,n,g,z
      |d > r
      |i > t,n,s,l,x,v
      |s > s,e,r,q,d,n,o,g,z
      |q > u
      |V > y
      |y > n,v,t
      |l > a,d,e,r,q,n,o,g,z,k,v
      |g > o
      |o > r,t,v
      |T > i
      |u > i
      |z > e,r,q,d,n,o,g,z
      |N > y
      |W > y
      |G > a
      |M > o
      |a > r,v,l,z,i
      |t > h
      |K > r
      |h > e,r,q,d,n,o,g,z
      |A > x,e
      |k > e,r,q,d,n,o,g,z
      |n > o,e,r,q,d,n,g,z
      |S > e""".stripMargin
