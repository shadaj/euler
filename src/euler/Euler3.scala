package euler

import Util._

// Find the largest prime factor of a composite number.

object Euler3 extends App {
  println(primeFactors(600851475143L).last)
}