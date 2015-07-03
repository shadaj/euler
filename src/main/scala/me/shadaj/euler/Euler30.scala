package me.shadaj.euler

object Euler30 extends App {
  def digitPowers(power: Int) = {
    val maxDigits = Iterator.from(1).find(n =>
      Math.pow(10, n - 1).toInt > n * Math.pow(9, power)).get

    val powers = (0 to 9).map(n => Math.pow(n, power))
    (10 until Math.pow(10, maxDigits - 1).toInt).filter { n =>
      val fifthSum = n.toString.map(c => powers(c.asDigit)).sum
      fifthSum == n
    }.sum
  }

  println(digitPowers(5))
}
