package me.shadaj.euler

object Euler21 extends App {
  def d(num: Int) = {
    if (num == 0) 0
    else 1 + (2 to Math.sqrt(num).toInt).flatMap { n =>
      if (num % n == 0) {
        val brother = num / n
        if (brother == n) {
          List(n)
        } else {
          List(n, brother)
        }
      }  else List()
    }.sum
  }
  
  def isAmicable(a: Int) = {
    val b = d(a)
    a == d(b) && a != b
  }

  val answer = (0 until 10000).filter(isAmicable).sum
  println(answer)
}