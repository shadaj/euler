package euler
import scala.annotation.tailrec

// Find the largest prime factor of a composite number.

object Euler3 extends App {
  def primeFactors(num: Long): List[Long] = {
    val exists = (2L to math.sqrt(num).toLong).find(num % _ == 0)
    exists match {
      case Some(d) => d :: primeFactors(num/d)
      case None => List(num)
    }
  }

  println(primeFactors(600851475143L).last)

}