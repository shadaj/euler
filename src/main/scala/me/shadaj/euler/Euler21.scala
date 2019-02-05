package me.shadaj.euler

object Euler21 extends App {
  def d(num: Long) = {
    Util.properDivisorsSum(num)
  }

  def isAmicable(a: Long) = {
    val b = d(a)
    a == d(b) && a != b
  }

  val answer = (0L until 10000).filter(isAmicable).sum
  println(answer)
}
