package me.shadaj.euler

object Euler46 extends App {
  val answer = Iterator.from(1).flatMap { n =>
    val SEARCH_LIMIT = Math.pow(10, n).toInt

    val primes = Util.sieve(SEARCH_LIMIT)
    val sortedPrimes = primes.toArray.sorted
    val doubleSquares = (1 to Math.sqrt(SEARCH_LIMIT / 2).toInt).map(n => n * n * 2).toSet

    (9 to SEARCH_LIMIT by 2).filterNot(primes.contains).find(n =>
      !sortedPrimes.view.takeWhile(_ < n).exists(p => doubleSquares.contains(n - p))
    )
  }.next()

  println(answer)
}
