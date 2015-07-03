package me.shadaj.euler

object Euler29 extends App {
  def log2(n: Double): Double = {
    Math.log(n) / Math.log(2)
  }

  val minBase = 2 // cannot change, others depend on duplicates from this
  val maxBase = 1000
  val minPower = 2
  val maxPower = 1000

  val duplicates = (2 to log2(maxBase).toInt).map { power =>
    val powerPrimes = Util.primeFactors(power).map(_.toInt)
    val maxFromHead = maxPower / powerPrimes.head
    val prefixCount = maxFromHead - minPower + 1
    val allNumeratorCases = (2 until power).filterNot(power % _ == 0)

    val fromFractionCount = allNumeratorCases.flatMap { numerator =>
      val simplifiedNum = numerator / Util.gcf(numerator, power).toInt
      val start = Iterator.from(maxFromHead + 1).find(_ % simplifiedNum == 0).get
      val end = maxPower * numerator / power
      start to end by simplifiedNum
    }.distinct.length

    power -> (prefixCount + fromFractionCount)
  }.toMap

  println(duplicates)

  val answer = (minBase to maxBase).map { n =>
    val primeFactorsGrouped = Util.primeFactors(n).
      groupBy(identity).map(t => t._1 -> t._2.length.toLong)
    val primePowers = primeFactorsGrouped.values.toSeq
    val basePower = primePowers.reduce(Util.gcf).toInt
    if (basePower != 1) {
      val ans = (maxPower - minPower + 1) - duplicates(basePower)
      ans
    } else {
      maxPower - minPower + 1
    }
  }.sum

  println(answer)
}
