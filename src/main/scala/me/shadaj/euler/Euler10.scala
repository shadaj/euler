package me.shadaj.euler

/* The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/

object Euler10 extends App {
  def isPrime(num: Long) = {
    !(2L to math.sqrt(num).toInt).exists(num % _ == 0)
  }
  
  val answer = 2 + (3L to 2000000 by 2).filter(isPrime).sum
  println(answer)
}