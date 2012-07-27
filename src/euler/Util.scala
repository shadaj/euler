package euler

object Util {
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
}