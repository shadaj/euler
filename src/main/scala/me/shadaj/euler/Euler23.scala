package me.shadaj.euler

object Euler23 extends App {
  def isAbundant(num: Long) = {
    Util.properDivisorsSum(num) > num
  }

  val abundantNumbers = (2 to 28123).filter(n => isAbundant(n.toLong))
  println(abundantNumbers)

  val canBeWritten = new Array[Boolean](28123)
  for {
    a <- abundantNumbers.indices
    b <- a until abundantNumbers.length
    sum = abundantNumbers(a) + abundantNumbers(b) if sum <= 28123
  } {
    canBeWritten(sum - 1) = true
  }

  println((1 to 28123).filterNot(n => canBeWritten(n - 1)).sum)
}
