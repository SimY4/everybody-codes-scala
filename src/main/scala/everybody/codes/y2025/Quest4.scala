package everybody.codes.y2025

import scala.math.BigDecimal.RoundingMode

object Quest4:
  def solve(input: String): Int =
    val cogs = input.linesIterator.map(_.toInt).toVector

    (cogs.zip(cogs.tail).map(_.toDouble / _).product * 2025).floor.toInt

  def solve2(input: String): Long =
    val cogs = input.linesIterator.map(_.toInt).toVector

    (BigDecimal(cogs.zip(cogs.tail).map((f, s) => s.toDouble / f).product) * 10000000000000L)
      .setScale(0, RoundingMode.CEILING)
      .toLong

  def solve3(input: String): Long =
    val cogs = input.linesIterator.map {
      case s"$f|$s" => f.toInt   -> s.toInt
      case cog      => cog.toInt -> cog.toInt
    }.toVector

    (cogs
      .zip(cogs.tail)
      .map { case ((_, s), (f, _)) =>
        BigDecimal(s.toDouble / f)
      }
      .product * 100).setScale(0, RoundingMode.FLOOR).toLong

  val input = """1000
                |999
                |985
                |956
                |932
                |922
                |896
                |879
                |868
                |847
                |841
                |817
                |806
                |790
                |785
                |778
                |765
                |748
                |741
                |733
                |727
                |716
                |688
                |673
                |647
                |628
                |618
                |600
                |577
                |553
                |528
                |517
                |497
                |468
                |440
                |419
                |416
                |391
                |383
                |361
                |333
                |332
                |310
                |285
                |259
                |234
                |214
                |213
                |193
                |187""".stripMargin

  val input2 = """915
                 |911
                 |894
                 |891
                 |883
                 |882
                 |870
                 |867
                 |842
                 |838
                 |828
                 |815
                 |809
                 |788
                 |781
                 |755
                 |726
                 |701
                 |681
                 |663
                 |660
                 |653
                 |645
                 |638
                 |629
                 |618
                 |591
                 |579
                 |555
                 |548
                 |530
                 |523
                 |503
                 |488
                 |476
                 |452
                 |432
                 |415
                 |406
                 |395
                 |384
                 |356
                 |332
                 |322
                 |298
                 |285
                 |261
                 |249
                 |232
                 |196""".stripMargin

  val input3 = """699
                 |688|688
                 |680|680
                 |661|661
                 |655|1965
                 |646|646
                 |638|2552
                 |626|626
                 |609|2436
                 |604|604
                 |586|1758
                 |585|585
                 |573|2292
                 |562|562
                 |553|1659
                 |547|547
                 |545|2180
                 |531|531
                 |526|1052
                 |509|509
                 |500|1500
                 |485|485
                 |475|1425
                 |459|459
                 |454|454
                 |435|435
                 |421|1263
                 |411|411
                 |401|1604
                 |386|386
                 |368|1104
                 |360|360
                 |354|354
                 |352|352
                 |351|351
                 |348|348
                 |340|1020
                 |336|336
                 |326|326
                 |322|322
                 |315|945
                 |306|306
                 |296|296
                 |290|290
                 |284|852
                 |280|280
                 |277|1108
                 |269|269
                 |252|504
                 |205""".stripMargin
