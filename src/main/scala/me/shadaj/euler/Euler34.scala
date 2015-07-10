package me.shadaj.euler

import Util._

object Euler34 extends App {
  val factorials = (0 to 9).map(n => (n!).toInt)

  val maxDigits = Iterator.from(1).find(n =>
    Math.pow(10, n - 1).toInt > n * factorials(9)).get

  val ans = (10 until Math.pow(10, maxDigits - 1).toInt).filter { n =>
    val factorialSum = n.toString.map(c => factorials(c.asDigit)).sum
    factorialSum == n
  }.sum

  println(ans)
}
