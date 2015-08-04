package me.shadaj.euler

object Euler50 extends App {
  val allPrimes = Util.sieve(1000000)
  val sortedPrimes = allPrimes.toArray.sorted

  var best = (-1, -1) // (num, length of primes)

  for (i1 <- sortedPrimes.indices) {
    def helper(cur: Int, length: Int): Unit = {
      if (cur <= 1000000 && length <= sortedPrimes.length - i1) {
        val newCur = cur + sortedPrimes(i1 + length - 1)
        if (length > best._2 && Util.isPrime(newCur)) best = (newCur, length)
        helper(newCur, length + 1)
      }
    }

    helper(sortedPrimes(i1), 2)
  }

  println(best._1)
}
