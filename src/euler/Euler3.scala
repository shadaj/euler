package euler
import scala.annotation.tailrec

// Find the largest prime factor of a composite number.

object Euler3 extends App {
  def isPrime(num: Long) = {
    if (num == 2) {
      true
    }
    var i = 2
    var found = false
    while (found == false && i <= Math.sqrt(num)) {
      if (num % i == 0) {
        found = true
      } else {
        i = i + 1
      }
    }
    !found
  }
  @tailrec
  def primeFactorization(num: Long, curList: List[Long] = List()): List[Long] = {
    var i = 2
    var found = false
    while (!found && i <= num / 2) {
      if (num % i == 0 && isPrime(i)) {
        found = true
      } else {
        i = i + 1
      }

    }
    if (found) {
      primeFactorization(num / i, i :: curList)
    } else {
      num :: curList
    }
  }

  println(primeFactorization(600851475143L).head)

}