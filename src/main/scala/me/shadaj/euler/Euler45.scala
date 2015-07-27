package me.shadaj.euler

object Euler45 extends App {
  def isPentagonal(num: Long) = {
    val n = ((Math.sqrt(24*num + 1) + 1)/6).toInt
    (n.toLong * (3*n -1))/2 == num
  }

  def hexagonal(n: Int) = n.toLong * (2*n - 1)

  println(Iterator.from(144).map(hexagonal).find(isPentagonal).get)
}
