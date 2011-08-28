package euler

//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//
//What is the 10001st prime number?
object Euler7 extends App {
  def isPrime(num: Int) = {
    !(2 to Math.sqrt(num).toInt).exists(num % _ == 0)
  }
  
  def nthPrime(n: Int): Int = {
    var found = 0
    var i = 2
    while (found <= n) {
      if (isPrime(i)) {
        found = found + 1
      }
      if (found < n) {
        i = i + 1
      }
    }
    i
  }
  println(nthPrime(10001))
}