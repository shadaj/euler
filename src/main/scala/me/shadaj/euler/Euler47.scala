package me.shadaj.euler

object Euler47 extends App {
  val FACTOR_COUNT = 4

  def totalPrimeFactors(num: Long) = {
    Util.primeFactors(num).distinct.length
  }

  val ans = Iterator.from(1).filter(totalPrimeFactors(_) == FACTOR_COUNT).
    sliding(FACTOR_COUNT).find(s => s.last - s.head == FACTOR_COUNT - 1).get.head

  println(ans)
}
