package me.shadaj.euler

//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//
//What is the 10001st prime number?
object Euler7 extends App {
  def isPrime(num: Int) = {
    !(2 to math.sqrt(num).toInt).exists(num % _ == 0)
  }
    
  def nextPrimeFrom(n: Int) = {
    Iterator.from(n + 1).find(isPrime(_)).get
  }
  
  def primes = Iterator.iterate(2)(nextPrimeFrom)
  
  println(primes.drop(10000).next)
}
