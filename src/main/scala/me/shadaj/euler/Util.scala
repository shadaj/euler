package me.shadaj.euler

object Util {
  implicit class FactorialInt(val num: Int) extends AnyVal {
    def ! : BigInt = {
      (BigInt(1) to num).product
    }
  }

  def primeFactors(num: Long): List[Long] = {
    val exists = (2L to math.sqrt(num).toLong).find(num % _ == 0)
    exists match {
      case Some(d) => d :: primeFactors(num/d)
      case None => List(num)
    }
  }
  
  def gcf(a: Long, b: Long): Long = {
    if (b == 0) a
    else gcf(b, a % b)
  }
  
  def lcm(a: Long, b: Long) = {
    (a * b) / gcf(a,b)
  }

  def properDivisorsSum(num: Long) = {
    val factors = primeFactors(num)
    factors.groupBy(identity).map { case (base, group) =>
      val count = group.size
      (1 - Math.pow(base, count + 1)).toInt / (1 - base)
    }.product - num
  }
}