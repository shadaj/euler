package me.shadaj.euler

object Euler27 extends App {
  def isPrime(num: Int) = {
    !(2 to math.sqrt(num).toInt).exists(num % _ == 0)
  }

  val primesLessThan1000 = (2 until 1000).filter(isPrime)

  def aRange(b: Int) = {
    if (b == 2) -998 until 1000 by 2
    else -999 until 1000 by 2
  }

  def calculateFormula(a: Int, b: Int)(n: Int) = {
    (n * n) + (a * n) + b
  }

  val cases = for (b <- primesLessThan1000;
                   a <- aRange(b)) yield {
    val formula = calculateFormula(a, b)_
    val count = Iterator.from(1).dropWhile(n =>
      isPrime(Math.abs(formula(n)))).next()
    (a * b, count)
  }

  println(cases.maxBy(_._2)._1)
}
