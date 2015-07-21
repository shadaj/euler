package me.shadaj.euler

object Euler41 extends App {
  val digitsCases = (1 to 9).filterNot(n => (n * (n + 1))/2 % 3 == 0)

  def pandigitals(length: Int) = {
    (1 to length).permutations.map(_.mkString.toLong).toList
  }

  val allPandigitals = digitsCases.flatMap(pandigitals)

  println(allPandigitals.filter(Util.isPrime).max)
}
