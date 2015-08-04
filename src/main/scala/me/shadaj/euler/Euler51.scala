package me.shadaj.euler

object Euler51 extends App {
  def waysToPick(digits: Int): Seq[Seq[Boolean]] = {
    if (digits == 0) Seq(Seq()) else {
      waysToPick(digits - 1).flatMap(w => Seq(true +: w, false +: w))
    }
  }

  def setDigits(num: Int, digit: Int, picking: Seq[Boolean]) = {
    val numString = num.toString
    val retString = numString.zip(picking).map(t => if (t._2) digit.toString else t._1.toString).
      mkString
    retString.toInt
  }

  val allPrimes = Util.sieve(1000000)
  val allPrimesSorted = allPrimes.toArray.sorted

  val ans = allPrimesSorted.view.flatMap { basePrime =>
    val digits = Math.log10(basePrime).toInt + 1

    waysToPick(digits).tail.init.flatMap { picking =>
      val digited = (1 to 9).map(setDigits(basePrime, _, picking))
      if (digited.count(allPrimes.contains) == 8) {
        Some(digited.find(allPrimes.contains).get)
      } else {
        None
      }
    }
  }

  println(ans.head)
}
